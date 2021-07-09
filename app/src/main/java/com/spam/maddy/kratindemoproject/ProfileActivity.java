package com.spam.maddy.kratindemoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    TextView name,age,phone;
    Button update;
    private DBHelper mydb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile Activity");
      //  mydb = new DBHelper(this);

        name=findViewById(R.id.edtUProfileName);
        age=findViewById(R.id.edtProfileAge);
        phone=findViewById(R.id.edtProfileNo);


        getData();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.profilenv);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
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
                        //startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
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

    private void getData() {

        mydb = new DBHelper(getApplicationContext());
        SQLiteDatabase db = mydb.getReadableDatabase();
        String id="1";

        Cursor cursor = db.rawQuery("select * from PersonalInfo where id='"+id+"'",null);
        if (cursor.moveToFirst())
        {
            do
            {
                String s1 = cursor.getString(cursor.getColumnIndex("name"));
                String s2 = cursor.getString(cursor.getColumnIndex("age"));
                String s3 = cursor.getString(cursor.getColumnIndex("phone"));

                name.setText(s1);
                age.setText(s2);
                phone.setText(s3);

            }while (cursor.moveToNext());
        }

    }
}