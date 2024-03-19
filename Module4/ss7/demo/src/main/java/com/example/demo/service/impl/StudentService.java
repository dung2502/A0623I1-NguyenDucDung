package com.example.demo.service.impl;

import com.example.demo.models.Student;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {

        return studentRepository.searchByName("%" + "Hai" + "%");
    }

    @Override
    public void save(Student student) {
//        Validate dữ liệu, format, trùng lặp, codeClass có tồn tại không
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAllByName(String name) {
        return studentRepository.searchByName("%" + name + "%");
    }

    @Override
    public void deleteById(Integer code) {
        studentRepository.deleteById(code);
    }
}