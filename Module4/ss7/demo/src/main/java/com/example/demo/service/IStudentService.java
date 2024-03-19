package com.example.demo.service;

import com.example.demo.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    List<Student> findAllByName(String name);

    void deleteById(Integer code);
}
