package com.spam.maddy.kratindemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.spam.maddy.kratindemoproject.listeners.ToWindowOnClick;

public class MyMenuActivity extends AppCompatActivity {
    public static boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyMenuActivity.isOpen = true;
        setContentView(R.layout.activity_my_menu);
        getSupportActionBar().setTitle("Calories Dashboard");
        findViewById(R.id.from_menu_to_diary).setOnClickListener(new ToWindowOnClick(this, CalCalculatorActivity.class));
        findViewById(R.id.from_menu_to_diary_menu).setOnClickListener(new ToWindowOnClick(this, CalCalculatorActivity.class));
        findViewById(R.id.from_menu_to_profile).setOnClickListener(new ToWindowOnClick(this, CalProfileActivity.class));
        findViewById(R.id.from_menu_to_dishes).setOnClickListener(new ToWindowOnClick(this, DishActivity.class));
        findViewById(R.id.from_menu_to_exercises).setOnClickListener(new ToWindowOnClick(this, ExerciseActivity.class));
   //     findViewById(R.id.from_menu_to_statistic).setOnClickListener(new ToWindowOnClick(this, StatisticActivity.class));
    }

    public void onExitButton(final View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isOpen = false;
    }
}
