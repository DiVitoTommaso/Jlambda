package com.jlambda.util;

import com.jlambda.types.Expression;

import java.util.HashMap;
import java.util.Map;

public class ExtensionEnvironment extends HashMap<String, Expression> {

    private Map<String, Expression> parent;
    public ExtensionEnvironment(Map<String, Expression> parent) {
        this.parent = parent;
    }

    @Override
    public Expression put(String key, Expression value) {
        return super.put(key, value);
    }

    @Override
    public Expression get(Object key) {
        if(super.get(key) != null)
            return super.get(key);

        if(parent != null)
            return parent.get(key);

        return null;
    }
}