package com.example.googlemapapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.example.googlemapapp.databinding.ActivityWebviewBinding;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * desc:
 * author: zouhecan {hc.zou@ctrip.com}
 * date: 2020/4/27
 */
public class WebViewActivity extends Activity {
    private ArrayList<String> urls;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ActivityWebviewBinding binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        webView = binding.webView;
        urls = getIntent().getStringArrayListExtra("URLS");
        initWebViewClient();
        HashSet<String> set = new HashSet<String>(urls);
        if (set.size() < urls.size()) {
            Log.d("zouhecan", "有重复url");
        }
        for (String url : set) {
            Log.d("zouhecan", "startLoadUrl" + url);
            webView.loadUrl(url);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebViewClient() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);//允许JavaScript脚本运行
        webSettings.setDomStorageEnabled(true);//开启本地DOM存储
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("zouhecan", "onPageStarted:" + url);
            }

            @Override
            public void onPageFinished(WebView view, final String url) {
                super.onPageFinished(view, url);
                Log.d("zouhecan", "onPageFinished:" + url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.d("zouhecan", "onReceivedError:" + failingUrl);
                webView.loadUrl(failingUrl);
            }

            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                this.onReceivedError(view, error.getErrorCode(), error.getDescription().toString(), request.getUrl().toString());
                Log.d("zouhecan", "onReceivedError:" + request.getUrl().toString());
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                Log.d("zouhecan", "onReceivedSslError:" + error.toString());
                super.onReceivedSslError(view, handler, error);
            }
        });

        webView.setWebChromeClient(new WebChromeClient());
    }


}
