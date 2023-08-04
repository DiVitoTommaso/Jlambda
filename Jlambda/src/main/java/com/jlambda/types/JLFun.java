package com.jlambda.types;

import com.jlambda.core.JlambdaInterpreter;
import com.jlambda.core.JlambdaParser;
import com.jlambda.util.ExtensorsEnv;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JLFun extends Expression {

    private JlambdaInterpreter instance;
    public String param;
    public Map<String, Expression> funEnv;
    public JlambdaParser.ExprContext body;

    public JLFun(JlambdaInterpreter instance, String param, JlambdaParser.ExprContext body, Map<String, Expression> env) {
        this.instance = instance;
        this.param = param;
        this.body = body;
        this.funEnv = new ExtensorsEnv(env);
    }

    public Expression apply(Expression v) {
        try {
            HashMap<String, Expression> newEnv = new ExtensorsEnv(funEnv);
            newEnv.put(param, v);
            return instance.expr(body, newEnv);
        } catch (Exception e) {
            return null;
        }
    }

    public String toString(Map<String, Expression> env) {
        HashMap<String, Expression> newEnv = new ExtensorsEnv(env);
        newEnv.put(param, null);
        return String.format("\u03BB%s.(%s)", param, exprToString(body, newEnv));
    }

    @Override
    public String toString() {
        HashMap<String, Expression> newEnv = new ExtensorsEnv(funEnv);
        newEnv.put(param, null);
        return "\u03BB%s.(%s)".formatted(param, exprToString(body, newEnv));
    }
}