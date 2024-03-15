package com.codegym.springboot.models;

import jakarta.persistence.*;


@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", columnDefinition = "INT")
    private Integer code;
    @Column(name = "name_student", columnDefinition = "VARCHAR(100)")
    private String nameStudent;
    private Double point;
    @Column(name = "id_card")
    private String idCard;
    @Column(name = "code_class")
    private Integer codeClass;

    public Student() {
    }

    public Student(int code, String nameStudent, Double point, String idCard, int codeClass) {
        this.code = code;
        this.nameStudent = nameStudent;
        this.point = point;
        this.idCard = idCard;
        this.codeClass = codeClass;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(int codeClass) {
        this.codeClass = codeClass;
    }
}
