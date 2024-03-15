package com.codegym.a0623i1_springboot.services.impl;

import com.codegym.a0623i1_springboot.models.Student;
import com.codegym.a0623i1_springboot.repositories.IStudentRepository;
import com.codegym.a0623i1_springboot.services.IStudentService;
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
