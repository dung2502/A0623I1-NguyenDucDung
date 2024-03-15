package com.example.teststudent.model;


import java.sql.Date;

public class Person {
    private int id;
    private String name;
    private Date date;
    private String gender;
    private String phoneNumber;

    public Person() {
    }

    public Person(int id, String name, Date date, String gender, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Person(String name, Date date, String gender, String phoneNumber) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public  Date getDate() {
        return date;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
