package com.jlambda.types;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaFunction extends Expression {
    public final Method method;
    public final List<Object> args = new ArrayList<>();

    public JavaFunction(Method m) {
        if (m == null || !Modifier.isStatic(m.getModifiers()))
            throw new Error("NativeError: method must have at least 1 parameter, must be non null and static");
        method = m;
    }

    private static Expression jValueOf(Object o) {
        if (o == null)
            return new JLVoid();

        if (o instanceof Integer tmp)
            return new JLInt(tmp);

        if (o instanceof String tmp)
            return new JLString(tmp);

        if (o instanceof Boolean tmp)
            return new JLBool(tmp);

        if (o instanceof Double tmp) {
            if (tmp % 1 == 0)
                return new JLInt(tmp.intValue());
            return new JLFloat(tmp);
        }

        throw new Error("TypeError: unsupported native type: " + o.getClass().getSimpleName());
    }

    private static Object lambdaValueOf(Expression e) {
        if (e instanceof ExpressionLazy tmp)
            return tmp;

        if (e instanceof JLVoid)
            return null;

        if (e instanceof JLInt tmp)
            return tmp.v;

        if (e instanceof JLString tmp)
            return tmp.v;

        if (e instanceof JLBool tmp)
            return tmp.v;

        if (e instanceof JLFloat tmp) {
            if (tmp.v % 1 == 0)
                return (int) tmp.v;
            return tmp.v;
        }

        if (e instanceof JLFreeVar tmp) {
            return new Object() {
                public final String free = tmp.name;
            };
        }
        throw new Error("TypeError: function cannot be converted to native type");
    }

    public Expression apply(Expression e) {
        JavaFunction neww = new JavaFunction(method);
        neww.args.addAll(args);
        if (e != null)
            neww.args.add(e);

        if (neww.args.size() == neww.method.getParameterCount()) {
            try {
                return jValueOf(neww.method.invoke(null, Arrays.stream(neww.args.toArray()).map(el -> {
                    while (el instanceof ExpressionLazy tmp)
                        el = tmp.eval();
                    return lambdaValueOf((Expression) el);
                }).toList().toArray()));
            } catch (Exception ex) {
                throw new Error("NativeError: method invocation raised " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }

        return neww;
    }

    @Override
    public String toString() {
        return String.format("[Native Function]{%s}", method.getParameterCount() - args.size());
    }
}