package com.example.student.url;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final WebView w = (WebView) findViewById(R.id.webv);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Num1");
            w.setWebViewClient(new WebViewClient() {
            });
            w.getSettings().setJavaScriptEnabled(true);
            w.loadUrl(value);
        }
        else{
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl("http://www.google.com");

        }
    }
}
