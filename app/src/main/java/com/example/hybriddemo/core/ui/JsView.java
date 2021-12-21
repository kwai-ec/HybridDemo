package com.example.hybriddemo.core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.hybriddemo.core.ui.dom.DomElement;

public abstract class JsView<V extends View, D extends DomElement> {

    protected D mDomElement;
    protected V mNativeView;

    public void setDomElement(DomElement domElement) {
        mDomElement = (D) domElement;
    }

    public abstract String getType();

    public abstract V createViewInternal(Context context);

    public V createView(Context context) {
        V view = createViewInternal(context);
        mNativeView = view;
        ViewGroup.MarginLayoutParams layoutParams =
                new ViewGroup.MarginLayoutParams(getWidth(context), getHeight(context));
        layoutParams.setMargins(dp2px(mDomElement.marginLeft, context), dp2px(mDomElement.marginTop, context),
                dp2px(mDomElement.marginRight, context), dp2px(mDomElement.marginBottom, context));
        view.setLayoutParams(layoutParams);
        return view;
    }

    protected int getWidth(Context context) {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    protected int getHeight(Context context) {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    protected int dp2px(float dp, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
