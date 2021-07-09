package com.spam.maddy.kratindemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BookActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().setTitle("Book COVID-19 Vaccine");

        if (haveNetwork()) {
            webView = (WebView) findViewById(R.id.wv2);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("https://selfregistration.cowin.gov.in/");
            webView.setWebViewClient(new WebViewClient());
        } else if (!haveNetwork()) {
            Intent i = new Intent(BookActivity.this, NetworkAct.class);
            startActivity(i);
        }
    }

    private boolean haveNetwork()
    {
        boolean have_WIFI=false;
        boolean have_MobileData=false;
        ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos=cm.getAllNetworkInfo();

        for (NetworkInfo info:networkInfos)
        {
            if (info.getTypeName().equalsIgnoreCase("WIFI")) {
                if (info.isConnected())
                    have_WIFI = true;
            }
            if (info.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (info.isConnected())
                    have_MobileData = true;
            }
        }
        return have_MobileData || have_WIFI;
    }
}