package com.example.teststudent.DTO;

import com.example.teststudent.model.Person;

import java.sql.Date;

public class StudentDTO extends Person {
    private String className;

    public StudentDTO() {
    }

    public StudentDTO(String name, Date date, String gender, String phoneNumber, String className) {
        super(name, date, gender, phoneNumber);
        this.className = className;
    }

    public StudentDTO(int id, String name, Date date, String gender, String phoneNumber, String className) {
        super(id, name, date, gender, phoneNumber);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
