package com.spam.maddy.kratindemoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("About US");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.aboutnv);
        bottomNavigationView.setSelectedItemId(R.id.action_about);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        finish();
                        return true;

                    case R.id.action_covid:
                        startActivity(new Intent(getApplicationContext(),CovidActivity.class));
                        // finish();
                        return true;

                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        // finish();
                        return true;

                    case R.id.action_about:
                        //  startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        // finish();
                        return true;


                }
                return true;
            }
        });
    }
}