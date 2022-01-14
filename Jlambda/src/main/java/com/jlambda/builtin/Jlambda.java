package com.jlambda.builtin;

import com.jlambda.core.JlambdaInterpreter;
import com.jlambda.core.JlambdaLexer;
import com.jlambda.core.JlambdaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
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
                System.err.println("FileError: file not found at path: " + args[0]);
                System.exit(-1);
            } catch (Error e) {
                System.err.println(e.getMessage());
            }

        }

        System.out.print(">> ");
        while (true)
            try {
                interpreter.eval(scanner.nextLine());
                System.out.print(">> ");
            } catch (Error e) {
                System.err.println(e.getMessage());
                System.out.print(">> ");
            } catch (Exception ignored) {
                System.out.print(">> ");
            }

    }
}