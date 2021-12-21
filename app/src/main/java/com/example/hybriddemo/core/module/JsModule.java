package com.example.hybriddemo.core.module;

import com.eclipsesource.v8.V8Array;

import java.util.List;

public abstract class JsModule {

    public abstract String getName();

    public abstract List<String> getFunctionNames();

    public abstract Object execute(String functionName, V8Array params);

}
