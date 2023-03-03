package com.jlambda.core;

import com.jlambda.types.*;
import com.jlambda.util.ExtensorsEnv;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.Method;
import java.util.*;

public class JlambdaInterpreter {

    private final Map<String, Expression> env = new HashMap<>();
    private final Set<String> vars = new HashSet<>();
    private boolean load = true;

    private static String typeof(Expression e) {
        if (e instanceof JLVoid)
            return "nothing";
        if (e instanceof JLFun)
            return "function";
        if (e instanceof JavaFunction)
            return "native function";
        if (e instanceof JLInt)
            return "int";
        if (e instanceof JLString)
            return "string";
        if (e instanceof JLBool)
            return "bool";
        if (e instanceof JLFloat)
            return "float";
        if (e instanceof JLFreeVar)
            return "free var";

        return "unknown";
    }

    private boolean steps = false;
    private boolean byName = false;

    // Avoid duplicate print due to expression between parentheses
    private String last = "";

    public synchronized Expression expr(JlambdaParser.ExprContext ctx, Map<String, Expression> env) {
        // apply => first function, second and other can be functions or values
        Expression res;
        if (!byName)
            res = subExpr(ctx.subexpr(0), env);
        else
            res = new ExpressionLazy(this, ctx.subexpr(0), env);

        if (res instanceof ExpressionLazy || res instanceof JavaFunction || res instanceof JLFun) {
            String v1 = "\033[0mEval Expr => \033[0;33m" + Expression.subExprToString(ctx.subexpr(0), env) +
                    "\033[0m To => \033[0;32m" + res + "\033[0m =>";
            if (steps && !last.equals(v1))
                System.out.println(last = v1);
        }

        for (int i = 1; i < ctx.subexpr().size(); i++) {
            Expression tmp;
            if (!byName)
                tmp = subExpr(ctx.subexpr(i), env);
            else
                tmp = new ExpressionLazy(this, ctx.subexpr(i), env);

            while (res instanceof ExpressionLazy lazy)
                res = lazy.eval();

            Expression old = res;

            String v3 = "\033[0mApply Arg => \033[0;33m" + tmp + "\033[0m To => \033[0;36m" + res + "\033[0m =>";
            if (steps && !last.equals(v3))
                System.out.println(last = v3);

            if (res instanceof JavaFunction jFun)
                res = jFun.apply(tmp);
            else if (res instanceof JLFun fun)
                res = fun.apply(tmp);
            else if (res instanceof JLFreeVar var) {
                res = new JLFreeVar(var.name + "(" + tmp + ")");
            } else
                throw new Error("TypeError: " + "Cannot apply " + typeof(res) + " to " + typeof(tmp));

            if (steps && !last.equals(v3))
                System.out.println("\033[0mObtaining => \033[0;32m" + res + "\033[0m => From => \033[0;36m" + old + "\033[0m => ");

        }
        return res;
    }

    public synchronized Expression subExpr(JlambdaParser.SubexprContext ctx, Map<String, Expression> env) {
        // values
        if (ctx.expr() == null) {
            // int
            if (ctx.INT() != null)
                return new JLInt(Integer.parseInt(ctx.INT().getText()));

            // float
            if (ctx.FLOAT() != null)
                return new JLFloat(Double.parseDouble(ctx.FLOAT().getText()));

            // bool
            if (ctx.BOOL() != null)
                return new JLBool(Boolean.parseBoolean(ctx.BOOL().getText()));

            // string
            if (ctx.STRING() != null)
                return new JLString(ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1));

            // var
            if (ctx.VARIABLE() != null)
                return env.get(ctx.VARIABLE().getText());
        }

        // load declaration
        if (ctx.load() != null) {
            if (!load)
                throw new Error("LoaderError: The native loader is disabled for this interpreter");
            return load(ctx.load());
        }

        // local declaration
        if (ctx.let() != null) {
            HashMap<String, Expression> newEnv = new ExtensorsEnv(env);
            return let(ctx.let(), newEnv);
        }

        // function declaration
        if (ctx.fun() != null)
            return new JLFun(this, ctx.fun().VARIABLE().getText(), ctx.fun().expr(), env);

        // if statement
        if (ctx.select() != null) {
            Expression result = expr(ctx.select().expr(0), env);

            while (result instanceof ExpressionLazy lazy)
                result = lazy.eval();

            if (!(result instanceof JLBool tmp))
                throw new Error("TypeError: Non boolean if guard");

            if (tmp.v)
                return expr(ctx.select().expr(1), env);
            else
                return expr(ctx.select().expr(2), env);
        }

        // expr between parentheses
        if (ctx.expr() != null)
            return expr(ctx.expr(), env);

        if (ctx.children.get(0).getText().equals("("))
            return new JLVoid();

        throw new Error("FatalError: Expression not recognized");
    }

    public synchronized JavaFunction load(JlambdaParser.LoadContext load) {
        StringBuilder tmp = new StringBuilder();
        ArrayList<String> params = new ArrayList<>();
        StringBuilder ret = new StringBuilder();

        for (ParseTree v : load.children) {
            if (v.getText().equals("load"))
                continue;

            if (v.getText().equals(".")) {
                tmp.append(".");
                continue;
            }

            if (v.getText().equals("("))
                break;

            tmp.append(v.getText());
        }

        boolean next = false;
        boolean interrupt = false;

        for (ParseTree v : load.children) {
            if (v.getText().equals("(") || v.getText().equals(")") || v.getText().equals(",")) {
                next = true;
                continue;
            }

            if (!next)
                continue;

            if (interrupt) {
                ret.append(v.getText());
                break;
            }

            if (v.getText().equals(":")) {
                interrupt = true;
                continue;
            }

            params.add(v.getText());
        }


        String method = tmp.substring(tmp.lastIndexOf(".") + 1);
        tmp.delete(tmp.lastIndexOf("."), tmp.length());

        try {
            Class<?> clz = Class.forName(tmp.toString());
            List<Method> ms = Arrays.stream(clz.getMethods()).filter(e -> e.getName().equals(method)).toList();
            for (Method m : ms) {
                boolean valid = true;

                if (params.size() == m.getParameterCount()) {
                    for (int i = 0; i < m.getParameterCount(); i++)
                        if (!m.getParameterTypes()[i].getSimpleName().equals(params.get(i))) {
                            valid = false;
                            break;
                        }

                    if (!m.getReturnType().getSimpleName().equals(ret.toString()))
                        valid = false;

                    if (valid)
                        return new JavaFunction(m);
                }
            }
        } catch (Exception ignored) {
        }

        throw new Error("NativeError: No method not found with the given signature.");
    }

    public synchronized Expression let(JlambdaParser.LetContext ctx, Map<String, Expression> env) {
        if (ctx.expr() != null) {
            Expression res = expr(ctx.expr(), env);
            while (res instanceof ExpressionLazy tmp)
                res = tmp.eval();
            env.put(ctx.VARIABLE().getText(), res);
            return res;
        } else {
            Expression res = new JLFreeVar(ctx.VARIABLE().getText());
            env.put(ctx.VARIABLE().getText(), res);
            return res;
        }
    }

    public synchronized void fvExpr(JlambdaParser.ExprContext ctx, Set<String> vars) {
        for (JlambdaParser.SubexprContext c : ctx.subexpr())
            fvSubExpr(c, vars);
    }

    public synchronized void fvSubExpr(JlambdaParser.SubexprContext ctx, Set<String> vars) {
        if (ctx.select() != null) {
            for (JlambdaParser.ExprContext c : ctx.select().expr())
                fvExpr(c, vars);
            return;
        }

        if (ctx.fun() != null) {
            HashSet<String> newEnv = new HashSet<>(vars);
            newEnv.add(ctx.fun().VARIABLE().getText());
            fvExpr(ctx.fun().expr(), newEnv);
            return;
        }

        if (ctx.let() != null) {
            HashSet<String> newEnv = new HashSet<>(vars);
            fvLet(ctx.let(), newEnv);
            fvExpr(ctx.expr(), newEnv);
            return;
        }

        if (ctx.VARIABLE() != null) {
            if (!vars.contains(ctx.VARIABLE().getText()))
                throw new Error("NameError: Unbound name: " + ctx.VARIABLE().getText());
        }
    }

    public synchronized void fvLet(JlambdaParser.LetContext ctx, Set<String> vars) {
        if (ctx.expr() != null)
            fvExpr(ctx.expr(), vars);
        vars.add(ctx.VARIABLE().getText());
    }

    private synchronized String stmt(JlambdaParser.StmtContext ctx) {
        JlambdaParser.ExprContext temp = null;
        try {
            StringBuilder result = new StringBuilder();

            for (ParseTree tree : ctx.children) {
                if (tree instanceof JlambdaParser.LetContext tmp) {
                    if (tmp.expr() != null) {
                        temp = tmp.expr();

                        for (ParseTree e : tmp.expr().children) {
                            if (e.getText().equals("steps"))
                                steps = true;

                            if (e.getText().equals("name"))
                                byName = true;
                        }
                    }

                    fvLet(tmp, vars);
                    result.append("val ")
                            .append(tmp.VARIABLE().getText())
                            .append(" => ")
                            .append(let(tmp, env))
                            .append("\n");
                }

                if (tree instanceof JlambdaParser.ExprContext tmp) {
                    temp = tmp;
                    fvExpr(tmp, vars);

                    for (ParseTree e : tmp.children) {
                        if (e.getText().equals("steps"))
                            steps = true;

                        if (e.getText().equals("name"))
                            byName = true;
                    }

                    Expression res = expr(tmp, env);
                    while (res instanceof ExpressionLazy lazy)
                        res = lazy.eval();
                    result.append("val - => ").append(res).append("\n");
                }
            }
            return result.toString();
        } catch (StackOverflowError e) {
            throw new Error("LoopError: infinite function application in expression: " + Expression.exprToString(temp, env));
        } finally {
            byName = false;
            steps = false;
        }
    }

    /**
     * evaluate Jlambda code
     *
     * @param code code to eval
     * @return the output of the evaluation
     */

    public synchronized String eval(String code) {
        JlambdaLexer lexer = new JlambdaLexer(CharStreams.fromString(code));
        JlambdaParser parser = new JlambdaParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                System.out.printf("\033[0;31mSyntaxError: Unrecognized token at: [%s,%s]. %s\n", i, i1, s);
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

            }
        });
        parser.removeErrorListeners();
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                System.out.printf("\033[0;31mSyntaxError: Unrecognized syntax at: [%s,%s]. %s\n", i, i1, s);
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

            }
        });
        return stmt(parser.stmt());
    }

    /**
     * reset the environment to empty
     */
    public synchronized void reset() {
        env.clear();
    }

    /**
     * register native java method to the interpreter
     *
     * @param var name to associate the method
     * @param m   the method to register
     * @return the result of the evaluation
     */
    public synchronized String register(String var, Method m) {
        env.put(var, new JavaFunction(m));
        return "val " + var + " => " + String.format("[Native Function]{%s}", m.getParameterCount());
    }

    public synchronized void allowLoad(boolean allow) {
        load = allow;
    }
}