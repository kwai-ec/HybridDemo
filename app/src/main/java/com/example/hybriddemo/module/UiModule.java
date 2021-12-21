package com.example.hybriddemo.module;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.example.hybriddemo.core.module.JsModule;
import com.example.hybriddemo.core.ui.RenderManager;
import com.example.hybriddemo.core.ui.dom.DomFactory;

import java.util.ArrayList;
import java.util.List;

public class UiModule extends JsModule {
    @Override
    public String getName() {
        return "$view";
    }

    @Override
    public List<String> getFunctionNames() {
        List<String> functionNames = new ArrayList<>();
        functionNames.add("render");
        return functionNames;
    }

    @Override
    public Object execute(String functionName, V8Array params) {
        switch (functionName) {
            case "render":
                V8Object param1 = params.getObject(0);
                V8Object rootViewObj = param1.getObject("rootView");
                RenderManager.getInstance().render(rootViewObj);
                break;
        }
        return null;
    }
}
