package com.example.hybriddemo.view;

import android.content.Context;
import android.widget.Button;

import com.example.hybriddemo.core.ui.JsView;
import com.example.hybriddemo.core.ui.dom.DomButton;

public class ButtonJsView extends JsView<Button, DomButton> {
    @Override
    public String getType() {
        return "button";
    }

    @Override
    public Button createViewInternal(Context context) {
        Button button = new Button(context);
        button.setOnClickListener(v -> mDomElement.onClick.call(mDomElement.onClick.getRuntime(), null));
        button.setText(mDomElement.text);
        button.setTextSize(16);
        return button;
    }
}
