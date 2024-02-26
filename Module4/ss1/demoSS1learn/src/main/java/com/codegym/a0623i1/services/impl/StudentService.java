package com.codegym.a0623i1.services.impl;

import com.codegym.a0623i1.models.Student;
import com.codegym.a0623i1.repositories.IStudentRepository;
import com.codegym.a0623i1.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
