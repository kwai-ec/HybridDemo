package com.example.hybriddemo.core;

import android.content.Context;
import android.view.ViewGroup;

import com.example.hybriddemo.core.module.ModuleManager;
import com.example.hybriddemo.core.ui.RenderManager;

public class JsApplication {
    private JsContext mJsContext;

    public static JsApplication init(Context context, ViewGroup containerView) {
        JsApplication jsApplication = new JsApplication();
        JsContext jsContext = new JsContext();
        jsApplication.mJsContext = jsContext;
        RenderManager.getInstance().init(context, containerView);
        ModuleManager.getInstance().init(jsContext);
        return jsApplication;
    }

    public void run(JsBundle jsBundle) {
        mJsContext.runApplication(jsBundle);
    }
}
