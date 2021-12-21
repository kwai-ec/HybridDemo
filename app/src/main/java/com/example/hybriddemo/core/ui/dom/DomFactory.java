package com.example.hybriddemo.core.ui.dom;

import com.eclipsesource.v8.V8Object;

public class DomFactory {

    public static DomElement create(V8Object rootV8Obj) {
        String type = rootV8Obj.getString("type");
        switch (type) {
            case "text":
                DomText domText = new DomText();
                domText.parse(rootV8Obj);
                return domText;
            case "image":
                DomImage domImage = new DomImage();
                domImage.parse(rootV8Obj);
                return domImage;
            case "button":
                DomButton domButton = new DomButton();
                domButton.parse(rootV8Obj);
                return domButton;
            case "verticalLayout":
                DomVerticalLayout domVerticalLayout = new DomVerticalLayout();
                domVerticalLayout.parse(rootV8Obj);
                return domVerticalLayout;
        }
        return null;
    }
}
