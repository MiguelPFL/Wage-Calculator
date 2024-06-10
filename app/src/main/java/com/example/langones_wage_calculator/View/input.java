package com.example.langones_wage_calculator.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Objects;

import com.example.langones_wage_calculator.Model.WageCalcModel;
import com.example.langones_wage_calculator.R;



public class input extends AppCompatActivity {

    Button calculate;
    EditText enterName, enterTime;
    Spinner enterEmployeetype;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //code to hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        //
        setContentView(R.layout.input);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        WageCalcModel variable = new WageCalcModel();

        calculate = findViewById(R.id.button);
        enterName = findViewById(R.id.enterName);
        enterTime = findViewById(R.id.enterTime);
        enterEmployeetype = findViewById(R.id.employeetype);

        calculate.setOnClickListener(v -> {
            variable.setName(String.valueOf(enterName.getText()));
            variable.setHours(Integer.parseInt(enterTime.getText().toString()));
            variable.setType(String.valueOf(enterEmployeetype.getSelectedItem()));

            Intent input = new Intent(input.this,output.class);
            input.putExtra("name",variable.getName());
            input.putExtra("type",variable.getType());
            input.putExtra("time",variable.getHours());
            startActivity(input);
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.employeetypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterEmployeetype.setAdapter(adapter);
    }
}
