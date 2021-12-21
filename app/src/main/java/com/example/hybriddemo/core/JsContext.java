package com.example.hybriddemo.core;

import com.eclipsesource.v8.V8;

public class JsContext {

    private V8 mEngine;

    public JsContext() {
        init();
    }

    private void init() {
        mEngine = V8.createV8Runtime();
    }

    public V8 getEngine() {
        return mEngine;
    }

    public void runApplication(JsBundle jsBundle) {
        mEngine.executeStringScript(jsBundle.getAppJavaScript());
    }
}
