package com.jlambda.builtin;

import java.util.Scanner;

public class JLMethods {

    private static  Scanner scanner = new Scanner(System.in);
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

    public static String input() {
        return scanner.nextLine();
    }

    public static void print(String s) {
        System.out.print(s);
    }
    public static void println(String s) {
        System.out.println(s);
    }

}