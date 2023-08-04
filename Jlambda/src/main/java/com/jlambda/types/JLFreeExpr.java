package com.jlambda.types;

public class JLFreeExpr extends Expression {

    public String name;
    public JLFreeExpr first;
    public Expression second;

    public JLFreeExpr(String name) {
        first = null;
        second = null;
        this.name = name;
    }

    public JLFreeExpr(JLFreeExpr first, Expression second) {
        name = null;
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        if (name != null)
            return "'" + name;

        return first.toString() + " " + second.toString();
    }
}