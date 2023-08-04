package com.jlambda.types;

public class JLBool extends Expression {

    public boolean v;
    public JLBool(boolean v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return Boolean.toString(v);
    }

}