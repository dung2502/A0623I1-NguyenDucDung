package com.codegym.a0623i1.repositories;

import com.codegym.a0623i1.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
