package com.example.hybriddemo.core.ui.dom;

import com.eclipsesource.v8.V8Object;

public class DomButton extends DomElement {

    public String text;

    @Override
    public void parse(V8Object v8Object) {
        super.parse(v8Object);
        for (String key : v8Object.getKeys()) {
            switch (key) {
                case "text":
                    this.text = v8Object.getString("text");
                    break;
            }
        }
    }
}
