package com.example.langones_wage_calculator.Controller;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.example.langones_wage_calculator.Model.WageCalcModel;

public class WageReqFlow {
    static WageCalcModel variable = new WageCalcModel();

public static void Formula(String type, int time){
    //Regular Hours
    if(time <= 8) {
        variable.setHours(time);
        variable.setOvertimewage(0);
        variable.setOvertime(0);
        switch (type) {
            case "Regular":
                variable.setRegularwage(variable.getHours()*100);
                break;
            case "Probationary":
                variable.setRegularwage(variable.getHours()*90);
                break;
            case "Part-time":
                variable.setRegularwage(variable.getHours()*75);
        }
        variable.setTotalwage(variable.getRegularwage());
    } else {
        //For Overtime
        variable.setHours(time);
        variable.setOvertime(time - 8);
        switch (type) {
            case "Regular":
                variable.setOvertimewage(variable.getOvertime()*115);
                variable.setRegularwage(800);
                break;
            case "Probationary":
                variable.setOvertimewage(variable.getOvertime()*100);
                variable.setRegularwage(720);
                break;
            case "Part-time":
                variable.setOvertimewage(variable.getOvertime()*90);
                variable.setRegularwage(600);
        }
        variable.setTotalwage(variable.getOvertimewage() + variable.getRegularwage());
    }
}
    @SuppressLint("SetTextI18n")
    public static void Result(TextView wageresult, TextView regularwageresult, TextView overtimewageresult, TextView hoursresult, TextView overtimeresult) {
        wageresult.setText(Integer.toString(variable.getTotalwage()));
        regularwageresult.setText(Integer.toString(variable.getRegularwage()));
        overtimewageresult.setText(Integer.toString(variable.getOvertimewage()));
        hoursresult.setText(Integer.toString(variable.getHours()));
        overtimeresult.setText(Integer.toString(variable.getOvertime()));
    }

}
