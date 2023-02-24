package com.jlambda.types;

public class JLFreeVar extends Expression {

    public final String name;

    public JLFreeVar(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "free " + name;
    }
}