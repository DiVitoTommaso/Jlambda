package com.jlambda.types;

import com.jlambda.core.JlambdaParser;
import com.jlambda.util.ExtensorsEnv;

import java.util.Map;

public abstract class Expression {

    public static String exprToString(JlambdaParser.ExprContext ctx, Map<String, Expression> env) {
        var tmp = new StringBuilder();
        for (JlambdaParser.SubexprContext e : ctx.subexpr()) {
            if (!tmp.isEmpty())
                tmp.append(" ");
            tmp.append(subExprToString(e, env));
        }
        return tmp.toString();
    }

    public static String subExprToString(JlambdaParser.SubexprContext ctx, Map<String, Expression> env) {
        var tmp = new StringBuilder();

        if (ctx.let() != null) {
            Map<String, Expression> newEnv = new ExtensorsEnv(env);
            newEnv.put(ctx.let().VARIABLE().getText(), null);
            return tmp.append("let ")
                    .append(ctx.let().VARIABLE().getText())
                    .append(" = ")
                    .append(exprToString(ctx.let().expr(), newEnv))
                    .append(" in ")
                    .append(exprToString(ctx.let().expr(), newEnv))
                    .toString();
        }

        if (ctx.fun() != null) {
            return tmp.append("fun ")
                    .append(ctx.fun().VARIABLE().getText())
                    .append(" -> (")
                    .append(exprToString(ctx.fun().expr(), env))
                    .append(")")
                    .toString();
        }

        if (ctx.select() != null)
            return tmp.append(" if ")
                    .append(exprToString(ctx.select().expr(0), env))
                    .append(" then ")
                    .append(exprToString(ctx.select().expr(1), env))
                    .append(" else ")
                    .append(exprToString(ctx.select().expr(2), env))
                    .toString();

        if (ctx.expr() != null)
            return tmp.append(exprToString(ctx.expr(), env)).toString();

        if (ctx.children.get(0).getText().equals("("))
            return tmp.append("()").toString();

        if (ctx.VARIABLE() != null && env.get(ctx.VARIABLE().getText()) != null) {
            if (env.get(ctx.VARIABLE().getText()) instanceof JLFun fun)
                return fun.toString(env);

            return env.get(ctx.VARIABLE().getText()).toString();
        }

        return ctx.getText();
    }
}