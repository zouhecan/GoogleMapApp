package com.example.googlemapapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.example.googlemapapp.databinding.ActivityWebviewBinding;

/**
 * desc:
 * author: zouhecan {hc.zou@ctrip.com}
 * date: 2020/4/27
 */
public class WebViewActivity extends Activity {
    private String[] urls;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ActivityWebviewBinding binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        webView = binding.webView;
        urls = getIntent().getStringArrayExtra("URLS");
        initWebViewClient();
        for (String url : urls) {
            webView.loadUrl(url);
        }
    }

    private void initWebViewClient() {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return shouldOverrideUrlLoading(view, request.getUrl().toString());
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
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, final WebResourceRequest request) {
                return this.shouldInterceptRequest(view, request.getUrl().toString());
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return super.shouldInterceptRequest(view, url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.d("zouhecan", "onReceivedError:" + failingUrl);
            }

            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                this.onReceivedError(view, error.getErrorCode(), error.getDescription().toString(), request.getUrl().toString());
                Log.d("zouhecan", "onReceivedError:" + request.getUrl().toString());
            }

            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
    }


}
