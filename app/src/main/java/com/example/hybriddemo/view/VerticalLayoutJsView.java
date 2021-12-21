package com.example.hybriddemo.view;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hybriddemo.core.ui.JsView;
import com.example.hybriddemo.core.ui.JsViewGroup;
import com.example.hybriddemo.core.ui.dom.DomVerticalLayout;

public class VerticalLayoutJsView extends JsViewGroup<LinearLayout, DomVerticalLayout> {

    public VerticalLayoutJsView() {
    }

    @Override
    public String getType() {
        return "verticalLayout";
    }

    @Override
    public LinearLayout createViewInternal(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        for (JsView jsView : mChildren) {
            linearLayout.addView(jsView.createView(context));
        }
        return linearLayout;
    }

    @Override
    protected int getHeight(Context context) {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }
}
