package com.spam.maddy.kratindemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.spam.maddy.kratindemoproject.db.DataBase;
import com.spam.maddy.kratindemoproject.entities.Exercise;

public class ExerciseEditorActivity extends AppCompatActivity {
    static Exercise exercise;
    DataBase db;
    private String firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_editor);
        getSupportActionBar().setTitle("Exercise Add");
        db = DataBase.getDataBase(this);
        if (exercise == null) {
            exercise = new Exercise();
        }
        firstName = exercise.getName();
        ((EditText) findViewById(R.id.exercise_editor_exercise_name)).setText(exercise.getName());
        ((EditText) findViewById(R.id.exercise_editor_t_coeff)).setText(((Integer) exercise.getTimeCoefficient()).toString());
        ((EditText) findViewById(R.id.exercise_editor_q_coeff)).setText(((Integer) exercise.getQuantityCoefficient()).toString());
        findViewById(R.id.exercise_editor_OK_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercise.setName(((EditText) findViewById(R.id.exercise_editor_exercise_name)).getText().toString());
                exercise.setTimeCoefficient(Integer.parseInt(((EditText) findViewById(R.id.exercise_editor_t_coeff)).getText().toString()));
                exercise.setQuantityCoefficient(Integer.parseInt(((EditText) findViewById(R.id.exercise_editor_q_coeff)).getText().toString()));
                if (!firstName.equals(exercise.getName()))
                    db.deleteExercise(firstName);
                if (db.getExercise(exercise.getName()) == null)
                    db.addExercise(exercise);
                else
                    db.updateExercise(exercise);
                exercise = null;
                finish();
            }
        });
        findViewById(R.id.exercise_editor_cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercise = null;
                finish();
            }
        });

    }
}
