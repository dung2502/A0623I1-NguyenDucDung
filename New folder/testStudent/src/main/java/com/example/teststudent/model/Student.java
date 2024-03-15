package com.example.teststudent.model;

import java.sql.Date;

public class Student extends Person{
    private int classID;

    public Student() {
    }

    public Student(int classID) {

        this.classID = classID;
    }

    public Student(int id, String name, Date date, String gender, String phoneNumber, int classID) {
        super(id, name, date, gender, phoneNumber);
        this.classID = classID;
    }
    public Student(String name, Date date, String gender, String phoneNumber, int classID) {
        super(name, date, gender, phoneNumber);
        this.classID = classID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }
}
