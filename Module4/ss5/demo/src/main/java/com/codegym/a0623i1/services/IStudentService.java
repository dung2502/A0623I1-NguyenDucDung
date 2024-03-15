package com.codegym.a0623i1.services;

import com.codegym.a0623i1.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);
}
