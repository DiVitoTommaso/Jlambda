package com.jlambda.types;

public class JLFloat extends Expression {

    public double v;

    public JLFloat(double v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return Double.toString(v);
    }
}