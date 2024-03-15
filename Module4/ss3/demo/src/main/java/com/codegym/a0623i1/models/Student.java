package com.codegym.a0623i1.models;

public class Student {
    private Integer code;
    private String nameStudent;
    private Double point;
    private String idCard;
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
