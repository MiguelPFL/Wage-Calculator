package com.example.langones_wage_calculator.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.langones_wage_calculator.Controller.WageReqFlow;
import com.example.langones_wage_calculator.R;

import java.util.Objects;

public class output extends AppCompatActivity {

    TextView username, employeetype, totalwage, regularwage, overtimewage, hours, overtime;
    Button returnBTN;


    @Override
    @SuppressLint("SourceLockedOrientationActivity")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //
        //code to hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        //
        setContentView(R.layout.output);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        username = findViewById(R.id.nameOutput);
        employeetype = findViewById(R.id.employeeTypeOutput);
        totalwage = findViewById(R.id.totalWageOutput);
        regularwage = findViewById(R.id.regularWageOutput);
        overtimewage = findViewById(R.id.overtimeWageOutput);
        hours = findViewById(R.id.hoursOutput);
        overtime = findViewById(R.id.overtimeOutput);
        returnBTN = findViewById(R.id.returnBTN);

        returnBTN.setOnClickListener(v -> {
            Intent returnprev = new Intent(this, input.class);
            startActivity(returnprev);
        });

        Intent output = getIntent();
        String Name = output.getStringExtra("name");
        String EType = output.getStringExtra("type");
        int Time = output.getIntExtra("time", 0);
        username.setText(Name);
        employeetype.setText(EType);
        WageReqFlow.Formula(EType, Time);
        WageReqFlow.Result(totalwage, regularwage, overtimewage, hours, overtime);
    }
}
