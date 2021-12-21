package com.example.hybriddemo.core.ui.dom;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

import java.util.ArrayList;
import java.util.List;

public class DomGroup extends DomElement {
    public List<DomElement> children;

    @Override
    public void parse(V8Object v8Object) {
        super.parse(v8Object);
        List<DomElement> childElements = new ArrayList<>();
        V8Array childrenObj = v8Object.getArray("children");
        for (int i = 0; i < childrenObj.length(); i++) {
            childElements.add(DomFactory.create(childrenObj.getObject(i)));
        }
        this.children = childElements;
    }
}
