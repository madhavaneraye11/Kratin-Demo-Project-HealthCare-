package com.spam.maddy.kratindemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.spam.maddy.kratindemoproject.listeners.ToWindowOnClickWithClosing;
import com.spam.maddy.kratindemoproject.preferences.Profile;

public class CalProfileActivity extends AppCompatActivity {
    Profile profile;
    TextView optimalCalorieNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_profile);
        getSupportActionBar().setTitle("Calories Calculator");
        profile = Profile.getProfile(this);
        findViewById(R.id.from_profile_to_menu).setOnClickListener(new ToWindowOnClickWithClosing(this, MyMenuActivity.class));//кнопка "В меню"
        ((EditText) findViewById(R.id.profile_age)).setText(profile.getAge() + "");
        ((EditText) findViewById(R.id.profile_height)).setText(profile.getHeight() + "");
        ((EditText) findViewById(R.id.profile_weight)).setText(profile.getWeight() + "");

        ((RadioButton) findViewById(R.id.profile_woman_radio_button)).setChecked(!profile.getGender());

        optimalCalorieNumber = ((TextView) findViewById(R.id.profile_optimal_kal_number));

        ((Button) findViewById(R.id.btnCalculate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optimalCalorieNumber.setText(profile.calculateCalories() + " " + getString(R.string.kilocalories));
            }
        });

    }

    public void onGenderRadioButtonClick(View view) {
        switch (view.getId()) {
            case R.id.profile_man_radio_button:
                profile.setGender(this, true);
                break;
            case R.id.profile_woman_radio_button:
                profile.setGender(this, false);
                break;
        }
        optimalCalorieNumber.setText(profile.calculateCalories() + " " + getString(R.string.kilocalories));
        optimalCalorieNumber.requestLayout();
    }

    public void onHeightChangeButtonClick(View view) {
        profile.setHeight(this, Integer.parseInt(((EditText) view).getText().toString()));
        optimalCalorieNumber.setText(profile.calculateCalories() + " " + getString(R.string.kilocalories));
        optimalCalorieNumber.requestLayout();
    }

    public void onWeightChangeButtonClick(View view) {
        profile.setWeight(this, Integer.parseInt(((EditText) view).getText().toString()));
        optimalCalorieNumber.setText(profile.calculateCalories() + " " + getString(R.string.kilocalories));
        optimalCalorieNumber.requestLayout();
    }

    public void onAgeChangeButtonClick(View view) {
        profile.setAge(this, Integer.parseInt(((EditText) view).getText().toString()));
        optimalCalorieNumber.setText(profile.calculateCalories() + " " + getString(R.string.kilocalories));
        optimalCalorieNumber.requestLayout();
    }

    public void onAimCalorieChangeButtonClick(View view) {
        profile.setAimCalorie(this, Integer.parseInt(((EditText) view).getText().toString()));
        optimalCalorieNumber.setText(profile.calculateCalories() + " " + getString(R.string.kilocalories));
        optimalCalorieNumber.requestLayout();
    }

    @Override
    public void onDestroy() {
        profile.setHeight(this, Integer.parseInt(((EditText) findViewById(R.id.profile_height)).getText().toString()));
        profile.setWeight(this, Integer.parseInt(((EditText) findViewById(R.id.profile_weight)).getText().toString()));
        profile.setAge(this, Integer.parseInt(((EditText) findViewById(R.id.profile_age)).getText().toString()));

        profile.saveData(this);
        super.onDestroy();
    }
}
