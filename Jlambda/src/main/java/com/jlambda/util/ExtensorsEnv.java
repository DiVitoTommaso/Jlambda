package com.jlambda.util;

import com.jlambda.types.Expression;

import java.util.HashMap;
import java.util.Map;

public class ExtensorsEnv extends HashMap<String, Expression> {

    private Map<String, Expression> parent;
    public ExtensorsEnv(Map<String, Expression> parent) {
        this.parent = parent;
    }

    @Override
    public Expression put(String key, Expression value) {
        return super.put(key, value);
    }

    @Override
    public Expression get(Object key) {
        if(super.containsKey(key))
            return super.get(key);

        if(parent != null)
            return parent.get(key);

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " => " + parent.toString();
    }
}