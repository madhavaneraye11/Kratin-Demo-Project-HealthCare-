package com.spam.maddy.kratindemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DOBActivity extends AppCompatActivity {

    EditText name,age,phone;
    Button submit;
    private DBHelper mydb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_o_b);
        getSupportActionBar().setTitle("Emergency Contact");
        mydb = new DBHelper(this);

        name=findViewById(R.id.edtName);
        age=findViewById(R.id.edtAge);
        phone=findViewById(R.id.edtNo);
        submit=findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mydb.insertContact(name.getText().toString(), age.getText().toString(),phone.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Successfully Added",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DOBActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                } else{
                    Toast.makeText(getApplicationContext(), "not done",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}