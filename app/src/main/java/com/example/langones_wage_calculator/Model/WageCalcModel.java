package com.example.langones_wage_calculator.Model;

public class WageCalcModel {
    private String name, type;
    private int totalwage, overtimewage, regularwage, hours, overtime;

    //getters
    public String getName(){return name;}
    public String getType(){return type;}
    public int getTotalwage(){return totalwage;}
    public int getOvertimewage(){return overtimewage;}
    public int getRegularwage(){return regularwage;}
    public int getHours(){return hours;}
    public int getOvertime(){return overtime;}

    //setters
    public void setName(String name){this.name = name;}
    public void setType(String type){this.type = type;}
    public void setTotalwage(int totalwage){this.totalwage = totalwage;}
    public void setOvertimewage(int overtimewage){this.overtimewage = overtimewage;}
    public void setRegularwage(int regularwage){this.regularwage = regularwage;}
    public void setHours(int hours){this.hours = hours;}
    public void setOvertime(int overtime){this.overtime = overtime;}
}
