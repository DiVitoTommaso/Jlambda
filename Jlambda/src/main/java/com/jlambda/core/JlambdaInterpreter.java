package com.jlambda.core;

import com.jlambda.types.*;
import com.jlambda.util.ExtensionEnvironment;
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

    public Expression expr(JlambdaParser.ExprContext ctx, Map<String, Expression> env) {
        // apply => first function, second and other can be functions or values
        Expression res = subExpr(ctx.subexpr(0), env);

        for (int i = 1; i < ctx.subexpr().size(); i++) {
            Expression tmp = subExpr(ctx.subexpr(i), env);

            if (res instanceof JavaFunction jFun)
                res = jFun.apply(tmp);
            else if (res instanceof JLFun fun)
                res = fun.apply(tmp);
            else if (res instanceof JLFreeVar var) {
                res = new JLFreeVar(var.name + "(" + tmp.toString() + ")");
            } else
                throw new Error("TypeError: " + "Cannot apply " + typeof(res) + " to " + typeof(tmp));
        }
        return res;
    }

    public Expression subExpr(JlambdaParser.SubexprContext ctx, Map<String, Expression> env) {
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
            HashMap<String, Expression> newEnv = new ExtensionEnvironment(env);
            let(ctx.let(), newEnv);
            return expr(ctx.expr(), newEnv);
        }

        // function declaration
        if (ctx.fun() != null)
            return new JLFun(this, ctx.fun().VARIABLE().getText(), ctx.fun().expr(), env);

        // if statement
        if (ctx.select() != null) {
            Expression result = expr(ctx.select().expr(0), env);
            if (!(result instanceof JLBool tmp))
                throw new Error("TypeError: non boolean if guard");

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

    public JavaFunction load(JlambdaParser.LoadContext load) {
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

    public String let(JlambdaParser.LetContext ctx, Map<String, Expression> env) {
        if (ctx.expr() != null) {
            Expression res = expr(ctx.expr(), env);
            env.put(ctx.VARIABLE().getText(), res);
            return ctx.VARIABLE().getText() + " => " + res.toString();
        } else {
            env.put(ctx.VARIABLE().getText(), new JLFreeVar(ctx.VARIABLE().getText()));
            return ctx.VARIABLE().getText() + " => free";
        }
    }

    public void fvExpr(JlambdaParser.ExprContext ctx, Set<String> vars) {
        for (JlambdaParser.SubexprContext c : ctx.subexpr())
            fvSubExpr(c, vars);
    }

    public void fvSubExpr(JlambdaParser.SubexprContext ctx, Set<String> vars) {
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

    public void fvLet(JlambdaParser.LetContext ctx, Set<String> vars) {
        if (ctx.expr() != null)
            fvExpr(ctx.expr(), vars);
        vars.add(ctx.VARIABLE().getText());
    }

    private String stmt(JlambdaParser.StmtContext ctx) {
        try {
            StringBuilder result = new StringBuilder();
            for (ParseTree tree : ctx.children) {
                if (tree instanceof JlambdaParser.LetContext tmp) {
                    fvLet(tmp, vars);
                    result.append("val ").append(let(tmp, env)).append("\n");
                }
                if (tree instanceof JlambdaParser.ExprContext tmp) {
                    fvExpr(tmp, vars);
                    result.append("val - => ").append(expr(tmp, env)).append("\n");
                }
            }
            return result.toString();
        } catch (StackOverflowError e) {
            throw new Error("LoopError: infinite function application in expression: " + ctx.getText());
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