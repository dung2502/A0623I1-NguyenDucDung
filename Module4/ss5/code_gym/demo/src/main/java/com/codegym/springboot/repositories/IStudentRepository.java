package com.codegym.springboot.repositories;

import com.codegym.springboot.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from students  where name_student like :name ", nativeQuery = true)
    List<Student> searchByName(@Param("name")String name);

    List<Student> findAllByPointBetween(Double prev, Double next);
}
