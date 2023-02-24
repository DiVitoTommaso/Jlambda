package com.jlambda.types;

import com.jlambda.core.JlambdaParser;

import java.util.Map;
import java.util.Set;

public abstract class Expression {
    protected String exprToString(JlambdaParser.ExprContext ctx, Map<String, Expression> env, Set<String> vars) {
        var tmp = new StringBuilder();
        for (JlambdaParser.SubexprContext e : ctx.subexpr())
            tmp.append("(").append(subExprToString(e, env, vars)).append(")");
        return tmp.toString();
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
            return tmp.append("(").append(exprToString(ctx.expr(), env, vars)).append(")").toString();

        if (ctx.children.get(0).getText().equals("("))
            return tmp.append("()").toString();

        return ctx.getText();
    }
}