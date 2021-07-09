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

public class CovidActivity extends AppCompatActivity {
    WebView webView;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        getSupportActionBar().setTitle("COVID-19 Information");
        if (haveNetwork()) {
            webView = (WebView) findViewById(R.id.wv1);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("https://www.mohfw.gov.in/");
            webView.setWebViewClient(new WebViewClient());
        } else if (!haveNetwork()) {
            Intent i = new Intent(CovidActivity.this, NetworkAct.class);
            startActivity(i);
        }
        fab=findViewById(R.id.fabBook);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BookActivity.class));
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.covidNV);
        bottomNavigationView.setSelectedItemId(R.id.action_covid);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        finish();
                        return true;

                    case R.id.action_covid:
                      //  startActivity(new Intent(getApplicationContext(),CovidActivity.class));
                        // finish();
                        return true;

                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        // finish();
                        return true;

                    case R.id.action_about:
                         startActivity(new Intent(getApplicationContext(),AboutActivity.class));
                        // finish();
                        return true;


                }
                return true;
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