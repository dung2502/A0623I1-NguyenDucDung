package com.codegym.springboot.services;

import com.codegym.springboot.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    List<Student> findAllByName(String name);

    void deleteById(Integer code);
}
