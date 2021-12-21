package com.example.hybriddemo.core.ui;

import android.content.Context;
import android.view.View;

import com.example.hybriddemo.core.ui.dom.DomGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class JsViewGroup<T extends View, D extends DomGroup> extends JsView<T, D> {
    protected List<JsView> mChildren = new ArrayList<>();

    public void setChildren(List<JsView> children) {
        mChildren = children;
    }

    @Override
    public T createView(Context context) {
        return super.createView(context);
    }
}
