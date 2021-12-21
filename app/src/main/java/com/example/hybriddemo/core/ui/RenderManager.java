package com.example.hybriddemo.core.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.eclipsesource.v8.V8Object;
import com.example.hybriddemo.core.ui.dom.DomElement;
import com.example.hybriddemo.core.ui.dom.DomFactory;

public class RenderManager {

    private RenderManager() {
    }

    private static class Holder {
        private static final RenderManager INSTANCE = new RenderManager();
    }

    public static RenderManager getInstance() {
        return Holder.INSTANCE;
    }

    private Context mContext;
    private ViewGroup mContainerView;

    public void init(Context context, ViewGroup containerView) {
        mContext = context;
        mContainerView = containerView;
    }

    public void render(V8Object rootViewObj) {
        DomElement rootDomElement = DomFactory.create(rootViewObj);
        JsView rootJsView = JsViewFactory.create(rootDomElement);
        if (rootJsView != null) {
            View rootView = rootJsView.createView(mContext);
            mContainerView.addView(rootView);
        }
    }

    public View findViewById(String id) {
        return findViewById(mContainerView, id);
    }

    public View findViewById(ViewGroup parent, String id) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            Object idTag = child.getTag();
            if (idTag instanceof String && TextUtils.equals(id, (String) idTag)) {
                return child;
            }
            if (child instanceof ViewGroup) {
                return findViewById((ViewGroup) child, id);
            }
        }
        return null;
    }
}
