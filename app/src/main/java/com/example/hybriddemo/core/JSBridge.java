package com.example.hybriddemo.core;

import com.example.hybriddemo.core.module.JsModule;

public class JSBridge {
    private JsContext mJsContext;

    public JSBridge(JsContext jsContext) {
        mJsContext = jsContext;
    }

    public void registerJavaMethod(JsModule jsModule) {

    }

    public Object executeJs(String js) {
        return null;
    }
}
