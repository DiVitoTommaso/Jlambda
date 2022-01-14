package com.jlambda.core;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

@SuppressWarnings("unchecked")
public class JlambdaInterpreter {

    private final HashMap<String, Expression> env = new HashMap<>();

    private static abstract class Expression {
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
            return v;
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

    @SuppressWarnings("unchecked")
    private static class JLFun extends Expression {

        private final String param;
        private final HashMap<String, Expression> funEnv;
        private final JlambdaParser.ExprContext body;

        public JLFun(String param, JlambdaParser.ExprContext body, HashMap<String, Expression> env) {
            this.param = param;
            this.funEnv = (HashMap<String, Expression>) env.clone();
            this.body = body;
        }

        public Expression apply(Expression v) {
            HashMap<String, Expression> newEnv = (HashMap<String, Expression>) funEnv.clone();
            newEnv.put(param, v);
            return expr(body, newEnv);
        }

        @Override
        public String toString() {
            return "fun " + param + " -> " + body.getText().replaceAll("fun", "fun ").replaceAll("\\.|->", " -> ");
        }
    }

    private static String typeof(Expression e) {
        if (e instanceof JLFun)
            return "function";
        if (e instanceof JavaFunction)
            return "java function";
        if (e instanceof JLInt)
            return "int";
        if (e instanceof JLString)
            return "string";
        if (e instanceof JLBool)
            return "bool";
        if (e instanceof JLFloat)
            return "float";

        return "unknown";
    }

    private static Expression expr(JlambdaParser.ExprContext ctx, HashMap<String, Expression> env) {
        // values
        if (ctx.expr().size() == 0) {
            // int
            if (ctx.INT() != null)
                return new JLInt(Integer.parseInt(ctx.INT().toString()));

            // float
            if (ctx.FLOAT() != null)
                return new JLFloat(Double.parseDouble(ctx.FLOAT().toString()));

            // bool
            if (ctx.BOOL() != null)
                return new JLFloat(Double.parseDouble(ctx.BOOL().toString()));

            // string
            if (ctx.STRING() != null)
                return new JLString(ctx.STRING().toString());

            // var
            if (ctx.VARIABLE() != null)
                return env.get(ctx.VARIABLE().toString());
        }
        // local declaration
        if (ctx.expr().size() == 1 && ctx.let() != null) {
            HashMap<String, Expression> newEnv = (HashMap<String, Expression>) env.clone();
            let(ctx.let(), newEnv);
            return expr(ctx.expr(0), newEnv);
        }

        // function declaration
        if (ctx.expr().size() == 1 && ctx.VARIABLE() != null)
            return new JLFun(ctx.VARIABLE().toString(), ctx.expr(0), env);

        // expr between parentheses
        if (ctx.expr().size() == 1 && ctx.VARIABLE() == null)
            return expr(ctx.expr(0), env);

        // apply => first function, second and other can be functions or values
        Expression res = expr(ctx.expr(0), env);

        for (int i = 1; i < ctx.expr().size(); i++) {
            Expression tmp = expr(ctx.expr(i), env);

            if (res instanceof JavaFunction jFun)
                res = jFun.apply(tmp);
            else if (res instanceof JLFun fun)
                res = fun.apply(tmp);
            else
                throw new Error("TypeError: " + "Cannot apply " + typeof(res) + " to " + typeof(tmp));
        }
        return res;
    }

    private static String let(JlambdaParser.LetContext ctx, HashMap<String, Expression> env) {
        Expression res = expr(ctx.expr(), env);
        env.put(ctx.VARIABLE().toString(), res);
        return ctx.VARIABLE().toString() + " => " + res.toString();
    }

    private String stmt(JlambdaParser.StmtContext ctx) {
        try {
            StringBuilder result = new StringBuilder();
            for (ParseTree tree : ctx.children) {
                if (tree instanceof JlambdaParser.LetContext tmp)
                    result.append("val ").append(let(tmp, env));
                if (tree instanceof JlambdaParser.ExprContext tmp)
                    result.append("val - => ").append(expr(tmp, env));
            }

            return result.toString();
        } catch (StackOverflowError e) {
            throw new Error("LoopError: infinite function application in expression: " + ctx.getText());
        } catch (OutOfMemoryError e) {
            throw new Error("MemoryError: memory limit reached in expression: " + ctx.getText());
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

}