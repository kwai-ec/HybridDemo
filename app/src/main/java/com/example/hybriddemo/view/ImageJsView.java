package com.example.hybriddemo.view;

import android.content.Context;
import android.widget.ImageView;

import com.example.hybriddemo.R;
import com.example.hybriddemo.core.ui.JsView;
import com.example.hybriddemo.core.ui.dom.DomImage;

public class ImageJsView extends JsView<ImageView, DomImage> {

    @Override
    public String getType() {
        return "image";
    }

    @Override
    public ImageView createViewInternal(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.mipmap.js);
        return imageView;
    }

    @Override
    protected int getWidth(Context context) {
        return dp2px(mDomElement.width, context);
    }

    @Override
    protected int getHeight(Context context) {
        return dp2px(mDomElement.width, context);
    }
}
