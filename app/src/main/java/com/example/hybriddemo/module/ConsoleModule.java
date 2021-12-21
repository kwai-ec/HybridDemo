package com.example.hybriddemo.module;

import android.util.Log;

import com.eclipsesource.v8.V8Array;
import com.example.hybriddemo.core.module.JsModule;

import java.util.ArrayList;
import java.util.List;

public class ConsoleModule extends JsModule {

    @Override
    public String getName() {
        return "console";
    }

    @Override
    public List<String> getFunctionNames() {
        List<String> functions = new ArrayList<>();
        functions.add("info");
        return functions;
    }

    @Override
    public Object execute(String functionName, V8Array params) {
        switch (functionName) {
            case "info":
                Log.i("Javascript Console", params.getString(0));
                break;
        }
        return null;
    }
}
