package com.ga.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        EditText grade1 = (EditText) findViewById(R.id.PlainText_Grade1);
        EditText grade2 = (EditText) findViewById(R.id.PlainText_Grade2);
        EditText grade3 = (EditText) findViewById(R.id.PlainText_Grade3);
        EditText grade4 = (EditText) findViewById(R.id.PlainText_Grade4);
        EditText grade5 = (EditText) findViewById(R.id.PlainText_Grade5);
        EditText result = (EditText) findViewById(R.id.editTextResult);
        //|| grade2.getText()=="" || grade3.getText()=="" || grade4.getText()=="" || grade5.getText()=="") {
        if (TextUtils.isEmpty(grade1.getText()) || TextUtils.isEmpty(grade2.getText()) || TextUtils.isEmpty(grade3.getText()) || TextUtils.isEmpty(grade4.getText()) || TextUtils.isEmpty(grade5.getText())) {
            Toast.makeText(getApplicationContext(), "Please enter a grade for each course", Toast.LENGTH_SHORT).show();
        } else {
            gpaResult = (Float.parseFloat(grade1.getText().toString()) + Float.parseFloat(grade2.getText().toString()) + Float.parseFloat(grade3.getText().toString()) +
                    Float.parseFloat(grade4.getText().toString()) + Float.parseFloat(grade5.getText().toString())) / 5;
            gpaString = String.valueOf(gpaResult);
            result.setText(gpaString);
        }

        if (gpaResult <60) {
            layout1.setBackgroundColor(Color.RED);
        }
        else if (gpaResult >= 61 && gpaResult <= 79){
            layout1.setBackgroundColor(Color.YELLOW);
        }
        else if (gpaResult >= 80 && gpaResult <= 100){
            layout1.setBackgroundColor(Color.GREEN);
        }
    }
}