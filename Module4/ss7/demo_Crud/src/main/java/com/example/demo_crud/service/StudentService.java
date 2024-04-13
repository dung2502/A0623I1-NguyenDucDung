package com.example.demo_crud.service;

import com.example.demo_crud.model.Student;
import org.hibernate.query.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface StudentService {

    void save(Student student);

    Student findById(long id);

//    Page<Student> findAll(Pageable pageable);
}
