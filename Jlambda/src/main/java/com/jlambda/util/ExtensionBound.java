package com.jlambda.util;

import java.util.HashSet;
import java.util.Set;

public class ExtensionBound extends HashSet<String> {

    private Set<String> parent;
    private ExtensionBound(Set<String> parent) {
        this.parent = parent;
    }

    @Override
    public boolean add(String v) {
        return super.add(v);
    }

    @Override
    public boolean contains(Object key) {
        if(super.contains(key))
            return true;

        if(parent != null)
            return parent.contains(key);

        return false;
    }
}