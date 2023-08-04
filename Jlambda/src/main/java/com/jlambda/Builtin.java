package com.jlambda;

import java.util.Scanner;

public class Builtin {

    private static Scanner scanner = new Scanner(System.in);

    public static boolean equals(int n1, int n2) {
        return n1 == n2;
    }

    public static boolean equals(double n1, double n2) {
        return n1 == n2;
    }

    public static boolean equals(String n1, String n2) {
        return n1.equals(n2);
    }

    public static String concat(String s1, String s2) {
        return s1 + s2;
    }

    public static int mul(int v1, int v2) {
        return v1 * v2;
    }

    public static double mul(double v1, double v2) {
        return v1 * v2;
    }

    public static double div(double v1, double v2) {
        return v1 / v2;
    }

    public static int idiv(int v1, int v2) {
        return v1 / v2;
    }

    public static double sub(double v1, double v2) {
        return v1 - v2;
    }

    public static int sub(int v1, int v2) {
        return v1 - v2;
    }

    public static int plus(int n1, int n2) {
        return n1 + n2;
    }

    public static double plus(double n1, double n2) {
        return n1 + n2;
    }

    public static int toInt(int v) {
        return v;
    }

    public static int toInt(double v) {
        return (int) v;
    }

    public static double toDouble(int v) {
        return (double) v;
    }

    public static double toDouble(double v) {
        return v;
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

    public static String format(String s1, String s2) {
        return s1.replaceFirst("%s", s2);
    }

}