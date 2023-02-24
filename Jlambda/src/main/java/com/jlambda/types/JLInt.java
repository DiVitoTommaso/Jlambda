package com.jlambda.types;
public class JLInt extends Expression {
    final int v;

    public JLInt(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return Integer.toString(v);
    }
}