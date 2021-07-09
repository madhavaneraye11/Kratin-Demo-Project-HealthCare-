package com.spam.maddy.kratindemoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MedicalActivity extends AppCompatActivity {
    WebView webView;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        getSupportActionBar().setTitle("Medical Store");
        if (haveNetwork()) {
            webView = (WebView) findViewById(R.id.medicalwv1);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("https://www.medplusmart.com/");
            webView.setWebViewClient(new WebViewClient());
        } else if (!haveNetwork()) {
            Intent i = new Intent(MedicalActivity.this, NetworkAct.class);
            startActivity(i);
        }
        fab=findViewById(R.id.fabMedicalBook);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MedicalBookActivity.class));
            }
        });

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

