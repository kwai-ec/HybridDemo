package com.example.hybriddemo.core.ui.dom;

import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;

public class DomElement {

    public String type;
    public int marginTop;
    public int marginBottom;
    public int marginLeft;
    public int marginRight;
    public V8Function onClick;

    public void parse(V8Object v8Object) {
        for (String key : v8Object.getKeys()) {
            switch (key) {
                case "type":
                    this.type = v8Object.getString("type");
                    break;
                case "marginTop":
                    this.marginTop = v8Object.getInteger("marginTop");
                    break;
                case "marginBottom":
                    this.marginBottom = v8Object.getInteger("marginBottom");
                    break;
                case "marginLeft":
                    this.marginLeft = v8Object.getInteger("marginLeft");
                    break;
                case "marginRight":
                    this.marginRight = v8Object.getInteger("marginRight");
                    break;
                case "onClick":
                    this.onClick = (V8Function) v8Object.get("onClick");
                    break;
                default:
                    break;
            }
        }
    }
}
