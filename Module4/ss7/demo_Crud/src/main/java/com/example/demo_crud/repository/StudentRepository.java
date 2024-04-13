package com.example.demo_crud.repository;

import com.example.demo_crud.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public class StudentRepository implements PagingAndSortingRepository<Student, Long> {
    @Override
    public Iterable<Student> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return null;
    }
}
