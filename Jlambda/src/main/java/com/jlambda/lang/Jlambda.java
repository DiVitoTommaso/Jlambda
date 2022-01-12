package com.jlambda.lang;

import com.jlambda.core.JlambdaInterpreter;
import com.jlambda.core.JlambdaLexer;
import com.jlambda.core.JlambdaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Jlambda {

    public static void register(String var, Method m) {
        JlambdaInterpreter.register(var, m);
    }

    public static void eval(String code) {
        JlambdaLexer lexer = new JlambdaLexer(CharStreams.fromString(code));
        JlambdaParser parser = new JlambdaParser(new CommonTokenStream(lexer));
        JlambdaInterpreter.stmt(parser.stmt());
    }

    public static void main(String[] args) {
        // example usage
        try {
            register("equal", JLBuiltin.class.getMethod("equal", Object.class, Object.class));
            register("mul", JLBuiltin.class.getMethod("mul", Number.class, Number.class));
            register("int", JLBuiltin.class.getMethod("intCast", Number.class));
        } catch (NoSuchMethodException ignored) {
        }

        Scanner scanner = new Scanner(System.in);

        if (args.length != 0) {
            try (Scanner fileScanner = new Scanner(new FileInputStream(args[0]))) {

                StringBuilder tmp = new StringBuilder();
                while (fileScanner.hasNextLine())
                    tmp.append(fileScanner.nextLine());

                eval(tmp.toString());
            } catch (Exception e) {
                System.err.println("FileError: file not found at path: " + args[0]);
                System.exit(-1);
            } catch (Error e){
                System.err.println(e.getMessage());
            }

        }

        System.out.print(">> ");
        while (true)
            try {
                eval(scanner.nextLine());
                System.out.print(">> ");
            } catch (Error e) {
                System.err.println(e.getMessage());
                System.out.print(">> ");
            } catch (Exception ignored) {
                System.out.print(">> ");
            }

    }
}