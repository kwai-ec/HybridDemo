package com.example.hybriddemo;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hybriddemo.core.JsApplication;
import com.example.hybriddemo.core.JsBundle;

public class MainActivity extends AppCompatActivity {

    private static final String JS_CODE = "const hello = \"Hello \";\n" +
            "const title = hello + \"Hybrid World\"\n" +
            "$view.render({\n" +
            "    rootView: {\n" +
            "        type: \"verticalLayout\",\n" +
            "        children: [\n" +
            "            {\n" +
            "                \"type\": \"text\",\n" +
            "                \"text\": title,\n" +
            "                \"textSize\": 24,\n" +
            "                \"marginTop\": 32\n" +
            "            },\n" +
            "            {\n" +
            "                \"type\": \"image\",\n" +
            "                \"width\": 172,\n" +
            "                \"height\": 172,\n" +
            "                \"marginTop\": 120,\n" +
            "                \"url\": \"\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"type\": \"button\",\n" +
            "                \"text\": \"点击打印日志\",\n" +
            "                \"marginTop\": 80,\n" +
            "                \"marginLeft\": 40,\n" +
            "                \"marginRight\": 40,\n" +
            "                \"onClick\": function () {\n" +
            "                    console.info(\"success!\")\n" +
            "                }\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "})";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout containerView = findViewById(R.id.js_container_view);

        JsBundle jsBundle = new JsBundle();
        jsBundle.setAppJavaScript(JS_CODE);

        JsApplication jsApplication = JsApplication.init(this, containerView);
        jsApplication.run(jsBundle);

    }

}
