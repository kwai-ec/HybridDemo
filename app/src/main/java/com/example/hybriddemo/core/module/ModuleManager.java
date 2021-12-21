package com.example.hybriddemo.core.module;

import com.eclipsesource.v8.V8Object;
import com.example.hybriddemo.core.JsContext;
import com.example.hybriddemo.module.ConsoleModule;
import com.example.hybriddemo.module.UiModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private ModuleManager() {
    }

    private static class Holder {
        private static final ModuleManager INSTANCE = new ModuleManager();
    }

    public static ModuleManager getInstance() {
        return Holder.INSTANCE;
    }

    private final List<JsModule> mModuleList = new ArrayList<>();
    private JsContext mJsContext;

    public void init(JsContext jsContext) {
        mJsContext = jsContext;
        mModuleList.add(new UiModule());
        mModuleList.add(new ConsoleModule());
        registerModules();
    }

    private void registerModules() {
        for (JsModule module : mModuleList) {
            V8Object moduleObj = new V8Object(mJsContext.getEngine());
            for (String functionName : module.getFunctionNames()) {
                moduleObj.registerJavaMethod((v8Object, params) -> {
                    return module.execute(functionName, params);
                }, functionName);
            }
            mJsContext.getEngine().add(module.getName(), moduleObj);
        }
    }
}
