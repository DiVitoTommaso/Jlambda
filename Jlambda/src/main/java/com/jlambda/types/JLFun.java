package com.jlambda.types;

import com.jlambda.core.JlambdaInterpreter;
import com.jlambda.core.JlambdaParser;
import com.jlambda.util.ExtensorsEnv;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JLFun extends Expression {

    private JlambdaInterpreter instance;
    public final String param;
    public final Map<String, Expression> funEnv;
    public final JlambdaParser.ExprContext body;

    public JLFun(JlambdaInterpreter instance, String param, JlambdaParser.ExprContext body, Map<String, Expression> env) {
        this.instance = instance;
        this.param = param;
        this.body = body;
        this.funEnv = new ExtensorsEnv(env);
    }

    public Expression apply(Expression v) {
        HashMap<String, Expression> newEnv = new ExtensorsEnv(funEnv);
        newEnv.put(param, v);
        return instance.expr(body, newEnv);
    }

    @Override
    public String toString() {
        return String.format("fun %s -> %s", param, exprToString(body, funEnv));
    }
}