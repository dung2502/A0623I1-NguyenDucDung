package com.example.teststudent.model;

import java.sql.Date;

public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(int id, String name, Date date, String gender, String phoneNumber) {
        super(id, name, date, gender, phoneNumber);
    }
    public Teacher(String name, Date date, String gender, String phoneNumber) {
        super(name, date, gender, phoneNumber);
    }

}
