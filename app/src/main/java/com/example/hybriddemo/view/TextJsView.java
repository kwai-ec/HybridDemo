package com.example.hybriddemo.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.hybriddemo.core.ui.JsView;
import com.example.hybriddemo.core.ui.dom.DomText;

public class TextJsView extends JsView<TextView, DomText> {

    @Override
    public String getType() {
        return "text";
    }

    @Override
    public TextView createViewInternal(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText(mDomElement.text);
        textView.setTextSize(mDomElement.textSize);
        textView.setTextColor(Color.parseColor(mDomElement.textColor));
        return textView;
    }
}
