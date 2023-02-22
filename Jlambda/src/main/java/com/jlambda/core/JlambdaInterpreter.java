package com.jlambda.core;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class JlambdaInterpreter {

    private final Map<String, Expression> env = new HashMap<>();
    private final Set<String> vars = new HashSet<>();
    private boolean load = true;
    private static abstract class Expression {
        protected String exprToString(JlambdaParser.ExprContext ctx, Map<String, Expression> env, Set<String> vars) {
            var tmp = new StringBuilder();
            if (ctx.fun() != null) {
                vars.add(ctx.fun().VARIABLE().getText());
                return tmp.append("fun ")
                        .append(ctx.fun().VARIABLE().getText())
                        .append(" -> (")
                        .append(exprToString(ctx.fun().expr(), env, vars))
                        .append(")").toString();
            }

            if (ctx.let() != null) {
                vars.add(ctx.let().VARIABLE().getText());
                return tmp.append("let ")
                        .append(ctx.let().VARIABLE().getText())
                        .append(exprToString(ctx.let().expr(), env, vars))
                        .append(" in ")
                        .append(exprToString(ctx.let().expr(), env, vars))
                        .toString();
            }

            if (ctx.select() != null)
                return tmp.append(" if ")
                        .append(exprToString(ctx.select().expr(0), env, vars))
                        .append(" then ")
                        .append(exprToString(ctx.select().expr(1), env, vars))
                        .append(" else ")
                        .append(exprToString(ctx.select().expr(2), env, vars))
                        .toString();

            if (ctx.expr() != null)
                return tmp.append("(").append(exprToString(ctx.expr(), env, vars)).append(")").toString();

            if (ctx.subexpr() != null) {
                tmp.append("(").append(exprToString(ctx.expr(), env, vars)).append(")");
                for (JlambdaParser.SubexprContext e : ctx.subexpr())
                    tmp.append("(").append(subExprToString(e, env, vars)).append(")");
                return tmp.toString();
            }

            if (ctx.VARIABLE() != null) {
                var str = ctx.VARIABLE().getText();
                if (env.containsKey(str) && !vars.contains(str))
                    tmp.append(env.get(str));
                else
                    tmp.append(str);
            }

            return ctx.getText();
        }

        protected String subExprToString(JlambdaParser.SubexprContext ctx, Map<String, Expression> env, Set<String> vars) {
            var tmp = new StringBuilder();
            if (ctx.fun() != null) {
                vars.add(ctx.fun().VARIABLE().getText());
                return tmp.append("fun ")
                        .append(ctx.fun().VARIABLE().getText())
                        .append(" -> (")
                        .append(exprToString(ctx.fun().expr(), env, vars))
                        .append(")").toString();
            }

            if (ctx.let() != null) {
                vars.add(ctx.let().VARIABLE().getText());
                return tmp.append("let ")
                        .append(ctx.let().VARIABLE().getText())
                        .append(exprToString(ctx.let().expr(), env, vars))
                        .append(" in ")
                        .append(exprToString(ctx.let().expr(), env, vars))
                        .toString();
            }

            if (ctx.select() != null)
                return tmp.append(" if ")
                        .append(exprToString(ctx.select().expr(0), env, vars))
                        .append(" then ")
                        .append(exprToString(ctx.select().expr(1), env, vars))
                        .append(" else ")
                        .append(exprToString(ctx.select().expr(2), env, vars))
                        .toString();

            if (ctx.expr() != null)
                tmp.append("(").append(exprToString(ctx.expr(), env, vars)).append(")").toString();

            return ctx.getText();
        }
    }

    private static class JLFreeVar extends Expression {

        private final String name;

        public JLFreeVar(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "free " + name;
        }
    }

    private static class JLBool extends Expression {
        private final boolean v;

        public JLBool(boolean v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return Boolean.toString(v);
        }

    }

    private static class JLFloat extends Expression {
        private final double v;

        public JLFloat(double v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return Double.toString(v);
        }
    }

    private static class JLString extends Expression {
        private final String v;

        public JLString(String v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return '"' + v + '"';
        }
    }

    private static class JLInt extends Expression {
        private final int v;

        public JLInt(int v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return Integer.toString(v);
        }
    }

    private static class JavaFunction extends Expression {
        private final Method method;
        private final List<Object> args = new ArrayList<>();

        public JavaFunction(Method m) {
            if (m == null || m.getParameterCount() == 0 || !Modifier.isStatic(m.getModifiers()))
                throw new Error("NativeError: method must have at least 1 parameter, must be non null and static");
            method = m;
        }

        private static Expression jValueOf(Object o) {
            if (o instanceof Integer tmp)
                return new JLInt(tmp);

            if (o instanceof String tmp)
                return new JLString(tmp);

            if (o instanceof Boolean tmp)
                return new JLBool(tmp);

            if (o instanceof Double tmp) {
                if (tmp % 1 == 0)
                    return new JLInt(tmp.intValue());
                return new JLFloat(tmp);
            }


            throw new Error("TypeError: unsupported native type: " + o.getClass().getSimpleName());

        }

        private static Object lambdaValueOf(Expression e) {
            if (e instanceof JLInt tmp)
                return tmp.v;

            if (e instanceof JLString tmp)
                return tmp.v;

            if (e instanceof JLBool tmp)
                return tmp.v;

            if (e instanceof JLFloat tmp) {
                if (tmp.v % 1 == 0)
                    return (int) tmp.v;
                return tmp.v;
            }

            if (e instanceof JLFreeVar tmp) {
                return new Object() {
                    public final String free = tmp.name;
                };
            }
            throw new Error("TypeError: function cannot be converted to native type");
        }

        public Expression apply(Expression e) {
            JavaFunction neww = new JavaFunction(method);
            neww.args.addAll(args);
            neww.args.add(lambdaValueOf(e));

            if (neww.args.size() == neww.method.getParameterCount()) {
                try {
                    return jValueOf(neww.method.invoke(null, neww.args.toArray()));
                } catch (Exception ex) {
                    throw new Error("NativeError: method invocation raised " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
                }
            }

            return neww;
        }

        @Override
        public String toString() {
            return String.format("[Native Function]{%s}", method.getParameterCount() - args.size());
        }
    }

    private static class JLFun extends Expression {

        private final String param;
        private final Map<String, Expression> funEnv;
        private final JlambdaParser.ExprContext body;

        public JLFun(String param, JlambdaParser.ExprContext body, Map<String, Expression> env) {
            this.param = param;
            this.funEnv = new HashMap<>(env);
            this.body = body;
        }

        public Expression apply(Expression v) {
            HashMap<String, Expression> newEnv = new HashMap<>(funEnv);
            newEnv.put(param, v);
            return expr(body, newEnv);
        }

        @Override
        public String toString() {
            return String.format("fun %s -> %s", param, exprToString(body, funEnv, new HashSet<>()));
        }
    }

    private static String typeof(Expression e) {
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

    private static Expression expr(JlambdaParser.ExprContext ctx, Map<String, Expression> env) {
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
            HashMap<String, Expression> newEnv = new HashMap<>(env);
            return load(ctx.load(), newEnv);
        }

        // local declaration
        if (ctx.let() != null) {
            HashMap<String, Expression> newEnv = new HashMap<>(env);
            let(ctx.let(), newEnv);
            return expr(ctx.expr(), newEnv);
        }

        // function declaration
        if (ctx.fun() != null)
            return new JLFun(ctx.fun().VARIABLE().getText(), ctx.fun().expr(), env);

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

    private static Expression subExpr(JlambdaParser.SubexprContext ctx, Map<String, Expression> env) {
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
            HashMap<String, Expression> newEnv = new HashMap<>(env);
            return load(ctx.load(), newEnv);
        }

        // local declaration
        if (ctx.let() != null) {
            HashMap<String, Expression> newEnv = new HashMap<>(env);
            let(ctx.let(), newEnv);
            return expr(ctx.expr(), newEnv);
        }

        // function declaration
        if (ctx.fun() != null)
            return new JLFun(ctx.fun().VARIABLE().getText(), ctx.fun().expr(), env);

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

        throw new Error("TypeError: -");
    }

    private static JavaFunction load(JlambdaParser.LoadContext load, HashMap<String, Expression> newEnv) {
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

            if (v.getText().equals("signat"))
                break;

            tmp.append(v.getText());
        }

        boolean next = false;
        boolean interrupt = false;

        for (ParseTree v : load.children) {
            if (v.getText().equals("signat")) {
                next = true;
                continue;
            }

            if (!v.getText().equals("signat") && !next)
                continue;

            if (v.getText().equals("(") || v.getText().equals(")") || v.getText().equals(","))
                continue;

            if (interrupt) {
                ret.append(v.getText());
                break;
            }

            if (v.getText().equals("=>")) {
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
                    if (!m.getReturnType().getName().equals(ret.toString()))
                        valid = false;

                    if (valid)
                        return new JavaFunction(m);
                }
            }
        } catch (Exception ignored) {
        }

        throw new Error("NativeError: No method not found with the given signature.");
    }

    private static String let(JlambdaParser.LetContext ctx, Map<String, Expression> env) {
        if (ctx.expr() != null) {
            Expression res = expr(ctx.expr(), env);
            env.put(ctx.VARIABLE().getText(), res);
            return ctx.VARIABLE().getText() + " => " + res.toString();
        } else {
            env.put(ctx.VARIABLE().getText(), new JLFreeVar(ctx.VARIABLE().getText()));
            return ctx.VARIABLE().getText() + " => free";
        }
    }

    private static void fvExpr(JlambdaParser.ExprContext ctx, Set<String> vars) {
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
            return;
        }

        for (JlambdaParser.SubexprContext c : ctx.subexpr())
            fvSubExpr(c, vars);

    }

    private static void fvSubExpr(JlambdaParser.SubexprContext ctx, Set<String> vars) {
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

    private static void fvLet(JlambdaParser.LetContext ctx, Set<String> vars) {
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
                    if(!load && tmp.expr().load() != null)
                        throw new Error("LoaderError: The native loader is disabled for this interpreter");

                    result.append("val ").append(let(tmp, env)).append("\n");
                }
                if (tree instanceof JlambdaParser.ExprContext tmp) {
                    fvExpr(tmp, vars);
                    if(!load && tmp.load() != null)
                        throw new Error("LoaderError: The native loader is disabled for this interpreter");

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
        env.put(var, new JlambdaInterpreter.JavaFunction(m));
        return "val " + var + " => " + String.format("[Native Function]{%s}", m.getParameterCount());
    }

    public synchronized void allowLoad(boolean allow) {
        load = allow;
    }
}