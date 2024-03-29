package com.jlambda.types;

import com.jlambda.core.JlambdaInterpreter;
import com.jlambda.core.JlambdaParser;

import java.util.Map;

public class ExpressionLazy extends Expression {

    private JlambdaInterpreter instance;
    public JlambdaParser.SubexprContext ctx;
    public Map<String, Expression> env;


    public ExpressionLazy(JlambdaInterpreter instance, JlambdaParser.SubexprContext ctx, Map<String, Expression> env) {
        this.instance = instance;
        this.ctx = ctx;
        this.env = env;
    }
    public Expression eval() {
        return instance.subExpr(ctx, env);
    }

    @Override
    public String toString() {
        return subExprToString(ctx, env);
    }
}