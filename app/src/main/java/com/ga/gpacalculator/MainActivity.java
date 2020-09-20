package com.ga.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculateGPA(View view) {

        double gpaResult = 0;
        String gpaString;
        String gradeColor = "";
        LinearLayout layout1 = (LinearLayout)findViewById(R.id.GPA_layout);
        Button button = (Button) view;
        EditText grade1 = (EditText) findViewById(R.id.PlainText_Grade1);
        EditText grade2 = (EditText) findViewById(R.id.PlainText_Grade2);
        EditText grade3 = (EditText) findViewById(R.id.PlainText_Grade3);
        EditText grade4 = (EditText) findViewById(R.id.PlainText_Grade4);
        EditText grade5 = (EditText) findViewById(R.id.PlainText_Grade5);
        EditText result = (EditText) findViewById(R.id.editTextResult);

        Log.i(TAG, button.getText().toString());
        if (button.getText()==getResources().getString(R.string.clear_button_text)){
            Log.i(TAG, "inside if");
            grade1.setText(null);
            grade2.setText(null);
            grade3.setText(null);
            grade4.setText(null);
            grade5.setText(null);
            result.setText(null);
            button.setText(R.string.compute_gpa_text);
            layout1.setBackgroundColor(Color.WHITE);
        }

        else if (TextUtils.isEmpty(grade1.getText()) || TextUtils.isEmpty(grade2.getText()) || TextUtils.isEmpty(grade3.getText()) ||
                TextUtils.isEmpty(grade4.getText()) || TextUtils.isEmpty(grade5.getText())) {
            Toast.makeText(getApplicationContext(), "Please enter a grade for each course", Toast.LENGTH_SHORT).show();
        }

        else  {
            gpaResult = (Float.parseFloat(grade1.getText().toString()) + Float.parseFloat(grade2.getText().toString()) + Float.parseFloat(grade3.getText().toString()) +
                    Float.parseFloat(grade4.getText().toString()) + Float.parseFloat(grade5.getText().toString())) / 5;
            gpaString = String.valueOf(gpaResult);
            result.setText(gpaString);


            if (gpaResult <60) {
                layout1.setBackgroundColor(Color.RED);
            }
            else if (gpaResult >= 61 && gpaResult <= 79){
                layout1.setBackgroundColor(Color.YELLOW);
            }
            else if (gpaResult >= 80 && gpaResult <= 100){
                layout1.setBackgroundColor(Color.GREEN);
            }
            button.setText(R.string.clear_button_text);
        }


    }
}