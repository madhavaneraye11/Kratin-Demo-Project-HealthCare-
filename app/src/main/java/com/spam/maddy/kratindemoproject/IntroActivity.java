package com.spam.maddy.kratindemoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

import org.jetbrains.annotations.Nullable;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_intro);


        addSlide(AppIntroFragment.newInstance("Hey!","Welcome to Health Care",R.drawable.intro1, Color.BLUE));
        addSlide(AppIntroFragment.newInstance("What we do!","We care of You",R.drawable.intro3, Color.GRAY));
        addSlide(AppIntroFragment.newInstance("1. Emergency SMS","SMS send on register number",R.drawable.smartphone,Color. parseColor("#87CEFA")));
        addSlide(AppIntroFragment.newInstance("2. Nearby Fitness Club(GYM)","Show all near by gyms and fitness clubs",R.drawable.location,Color. parseColor("#87CEFA")));
        addSlide(AppIntroFragment.newInstance("3. Nearby Hospitals","Show all near by hospitals",R.drawable.hospital,Color. parseColor("#87CEFA")));
        addSlide(AppIntroFragment.newInstance("4. Calories Calculator","Calculate Your Calories using your input",R.drawable.caloriescal,Color. parseColor("#87CEFA")));
        addSlide(AppIntroFragment.newInstance("5. Medicine/Doctor Reminder","Remind Your Medicine time and doctor meeting time",R.drawable.reminder,Color. parseColor("#87CEFA")));
        addSlide(AppIntroFragment.newInstance("6. Medical and Lab testing","Using this you can order medical and book slot for lab testing",R.drawable.medicine,Color. parseColor("#87CEFA")));
        addSlide(AppIntroFragment.newInstance("7. Emergency Call Services: Police, Ambulance, Fire and Family Member","Emergency Call Services: Police, Ambulance, Fire and Family Member",R.drawable.call,Color. parseColor("#87CEFA")));
        addSlide(AppIntroFragment.newInstance("8. COVID-19 Information and Slot booking for Vaccination","COVID-19 Information and Slot booking for Vaccination",R.drawable.vaccine,Color. parseColor("#87CEFA")));

        addSlide(AppIntroFragment.newInstance("Thank You!","Thank You So Much For Selecting Health Care Application",R.drawable.intro1, Color. parseColor("#F9AA33")));

    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent i = new Intent(IntroActivity.this, DOBActivity.class);
        startActivity(i);
        finish();

    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent i = new Intent(IntroActivity.this, DOBActivity.class);
        startActivity(i);
        finish();
    }


}