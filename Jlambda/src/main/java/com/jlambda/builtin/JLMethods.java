package com.jlambda.builtin;

public class JLMethods {

    public static boolean equal(Object o1, Object o2) {
        return o1.equals(o2);
    }

    public static double mul(Number v1, Number v2) {
        return v1.doubleValue() * v2.doubleValue();
    }

    public static double sub(Number v1, Number v2) {
        return v1.doubleValue() - v2.doubleValue();
    }

    public static int intCast(Number v) {
        return v.intValue();
    }

}