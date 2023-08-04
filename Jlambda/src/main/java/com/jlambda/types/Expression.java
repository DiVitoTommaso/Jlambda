package com.jlambda.types;

import com.jlambda.core.JlambdaParser;
import com.jlambda.util.ExtensorsEnv;
import com.jlambda.util.Pair;

import java.util.*;
import java.util.regex.Pattern;

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
            newEnv.put(ctx.let().VARIABLE().getText(), new JLFreeExpr(exprToString(ctx.let().expr(), newEnv)));
            return tmp.append(exprToString(ctx.expr(), newEnv)).toString();
        }

        if (ctx.fun() != null) {
            Map<String, Expression> newEnv = new ExtensorsEnv(env);
            newEnv.put(ctx.fun().VARIABLE().getText(), null);
            return tmp.append("\u03BB")
                    .append(ctx.fun().VARIABLE().getText())
                    .append(".(")
                    .append(exprToString(ctx.fun().expr(), newEnv))
                    .append(")")
                    .toString();
        }

        if (ctx.select() != null)
            return tmp.append("if ")
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

    public static String format(Expression res) {
        StringBuilder tmp = new StringBuilder(res.toString());
        HashMap<String, Integer> free = new HashMap<>();
        HashMap<String, Integer> next = new HashMap<>();

        StringBuilder var = new StringBuilder();

        int scope = 0;
        int i = 0;
        while (i < tmp.length()) {
            if (tmp.charAt(i) == '(')
                scope++;

            if (tmp.charAt(i) == ')')
                scope--;

            if (tmp.charAt(i) == '\'') {
                int j = i + 1;
                while (j < tmp.length() && ("" + tmp.charAt(j)).matches("[a-zA-Z0-9]")) {
                    var.append(tmp.charAt(j));
                    j++;
                }

                free.put(var.toString(), scope);
                var = new StringBuilder();
            }

            i++;
        }

        scope = 0;
        i = 0;

        boolean skip = false;

        boolean neww = true;
        int start = 0;

        while (i < tmp.length()) {
            if (tmp.charAt(i) == '[')
                skip = true;

            if (tmp.charAt(i) == '}')
                skip = false;

            if (skip)
                i++;

            if (tmp.charAt(i) == '\'') {
                tmp.deleteCharAt(i);
                int j = i;
                while (j < tmp.length() && ("" + tmp.charAt(j)).matches("[a-zA-Z]"))
                    j++;

                i = j + 1;
                continue;
            }

            if (tmp.charAt(i) == '(')
                scope++;

            if (tmp.charAt(i) == ')')
                scope--;

            if (tmp.charAt(i) == '(' || tmp.charAt(i) == ')' || tmp.charAt(i) == ' ' || tmp.charAt(i) == '.') {
                if (!var.isEmpty()) {
                    if (free.containsKey(var.toString()) && free.get(var.toString()) >= scope)
                        tmp.replace(start, i, var.toString() + next.get(var.toString()));

                    i = start + var.length() + next.getOrDefault(var.toString(), 0).toString().length() + 1;
                    var = new StringBuilder();
                } else
                    i++;
                neww = true;
                continue;
            }

            if (tmp.charAt(i) == '\u03BB') {
                int j = i + 1;
                while (j < tmp.length() && ("" + tmp.charAt(j)).matches("[a-zA-Z]")) {
                    var.append(tmp.charAt(j));
                    j++;
                }

                if (free.containsKey(var.toString()) && free.get(var.toString()) >= scope) {
                    next.merge(var.toString(), 1, Integer::sum);
                    tmp.replace(i + 1, j, var.toString() + next.get(var.toString()));
                }

                i += var.length() + next.getOrDefault(var.toString(), 0).toString().length() + 1;
                var = new StringBuilder();
            }

            if (("" + tmp.charAt(i)).matches("[a-zA-Z]")) {
                if (neww) {
                    neww = false;
                    start = i;
                }
                var.append(tmp.charAt(i));
            }

            i++;
        }

        return tmp.toString();
    }
}