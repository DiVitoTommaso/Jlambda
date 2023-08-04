package com.jlambda.types;

public class JLString extends Expression {
    public String v;

    public JLString(String v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return '"' + v + '"';
    }
}