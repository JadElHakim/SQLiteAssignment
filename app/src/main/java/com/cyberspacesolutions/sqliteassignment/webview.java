package com.cyberspacesolutions.sqliteassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class webview extends AppCompatActivity {
    Context context;
   // WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        context = this;
        //create new webview and set it as view
        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        //get extra from previous acitivity
        Intent intent = getIntent();
        String url = intent.getStringExtra("link");
        //load url from previous activity
        myWebView.loadUrl(url);
    }

}