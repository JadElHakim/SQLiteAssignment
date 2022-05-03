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

      //  mWebView = (WebView) findViewById(R.id.webView);
       // mWebView.setWebViewClient(new MyWebViewClient());
        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("link");
        myWebView.loadUrl(url);
     //   Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
      //  mWebView.loadUrl(url);
    }

//    private class MyWebViewClient extends WebViewClient{
//        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//            Intent i = new Intent(Intent.ACTION_VIEW, request.getUrl());
//            startActivity(i);
//            return true;
//        }
//    }
}