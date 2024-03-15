package com.example.teststudent.model;

public class Classes {
    private int classId;
    private String nameClass;
    private int teacherId;

    public Classes() {
    }
    public Classes(int classId, String nameClass, int teacherId) {
        this.classId = classId;
        this.nameClass = nameClass;
        this.teacherId = teacherId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
