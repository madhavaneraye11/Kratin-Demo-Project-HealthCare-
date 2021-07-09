package com.spam.maddy.kratindemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class MedAlarmActivity extends AppCompatActivity {
    private ArrayList al;
    private List list=new ArrayList();
    private ArrayAdapter<String> adapter;
    ListView lv;
    TextView tv;
    FloatingActionButton fab1;
    private String desc[] = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_alarm);
        getSupportActionBar().setTitle("Medicine Reminder");

        fab1=(FloatingActionButton)findViewById(R.id.floatingActionButton1);
        lv=(ListView)findViewById(R.id.rem_lv);
        tv=(TextView) findViewById(R.id.reminder_tv);


        DatabaseHandler db=new DatabaseHandler(getApplicationContext());
        list=db.getAllReminders();

        if(list.size()==0)
        {
            lv.setVisibility(GONE);

        }

        tv.setVisibility(GONE);

        adapter = new CustomList(MedAlarmActivity.this,list,desc);
        lv.setAdapter(adapter);

        //***Customised list view add***********************************************************************
       /* CustomList customList = new CustomList(getActivity(),list, desc);
        lv.setAdapter(customList);*/

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(),"You Clicked "+list.get(i),Toast.LENGTH_SHORT).show();
                //addReminderInCalendar();
                Intent in=new Intent(MedAlarmActivity.this,MedRemInfo.class);
                in.putExtra("id",list.get(i).toString());
                startActivity(in);
            }
        });


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddReminder.class));

            }
        });

    }


    public void receiveData(ArrayList al)
    {
        this.al=al;
        list.add(al.get(0));

    }
}