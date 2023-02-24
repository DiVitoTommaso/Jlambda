package com.jlambda.builtin;

import com.jlambda.core.JlambdaInterpreter;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

class Jlambda {

    private static final JlambdaInterpreter interpreter = new JlambdaInterpreter();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length != 0) {
            try (Scanner fileScanner = new Scanner(new FileInputStream(args[0]))) {

                StringBuilder tmp = new StringBuilder();
                while (fileScanner.hasNextLine())
                    tmp.append(fileScanner.nextLine());

                interpreter.eval(tmp.toString());
            } catch (Exception e) {
                System.out.println("\033[0;31mFileError: file not found at path: " + args[0]);
                System.exit(-1);
            } catch (Error e) {
                System.out.println("\033[0;31m" + e.getMessage());
            }
        }

        System.out.print("\033[0m>> ");
        while (true)
            try {
                System.out.print(interpreter.eval(scanner.nextLine()));
                System.out.print("\033[0m>> ");
            } catch (Error e) {
                System.out.println("\033[0;31m" + e.getMessage());
                System.out.print("\033[0m>> ");
            } catch (Exception ignored) {
                System.out.print("\033[0m>> ");
            }

    }
}