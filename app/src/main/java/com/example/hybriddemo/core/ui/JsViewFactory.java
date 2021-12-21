package com.example.hybriddemo.core.ui;

import com.example.hybriddemo.core.ui.dom.DomElement;
import com.example.hybriddemo.core.ui.dom.DomGroup;
import com.example.hybriddemo.view.ButtonJsView;
import com.example.hybriddemo.view.ImageJsView;
import com.example.hybriddemo.view.TextJsView;
import com.example.hybriddemo.view.VerticalLayoutJsView;

import java.util.ArrayList;
import java.util.List;

public class JsViewFactory {

    public static JsView create(DomElement domElement) {
        String type = domElement.type;
        switch (type) {
            case "text":
                TextJsView textJsView = new TextJsView();
                textJsView.setDomElement(domElement);
                return textJsView;
            case "image":
                ImageJsView imageJsView = new ImageJsView();
                imageJsView.setDomElement(domElement);
                return imageJsView;
            case "button":
                ButtonJsView buttonJsView = new ButtonJsView();
                buttonJsView.setDomElement(domElement);
                return buttonJsView;
            case "verticalLayout":
                VerticalLayoutJsView verticalLayoutJsView = new VerticalLayoutJsView();
                verticalLayoutJsView.setDomElement(domElement);
                if (domElement instanceof DomGroup) {
                    List<JsView> childrenJsView = new ArrayList<>();
                    for (DomElement childModel : ((DomGroup) domElement).children) {
                        childrenJsView.add(create(childModel));
                    }
                    verticalLayoutJsView.setChildren(childrenJsView);
                }
                return verticalLayoutJsView;
            default:
                return null;
        }
    }
}
