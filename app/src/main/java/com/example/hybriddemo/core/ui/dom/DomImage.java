package com.example.hybriddemo.core.ui.dom;

import com.eclipsesource.v8.V8Object;

public class DomImage extends DomElement {

    public int width;
    public int height;
    public String url;

    @Override
    public void parse(V8Object v8Object) {
        super.parse(v8Object);
        for (String key : v8Object.getKeys()) {
            switch (key) {
                case "width":
                    this.width = v8Object.getInteger("width");
                    break;
                case "height":
                    this.height = v8Object.getInteger("height");
                    break;
            }
        }
    }
}
