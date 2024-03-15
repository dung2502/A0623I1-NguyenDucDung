package com.codegym.a0623i1_springboot.services;

import com.codegym.a0623i1_springboot.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    List<Student> findAllByName(String name);

    void deleteById(Integer code);
}
