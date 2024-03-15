package com.example.teststudent.service;

import com.example.teststudent.DTO.StudentDTO;
import com.example.teststudent.model.Student;

import java.util.List;

public interface IStudentBO extends IService<Student>{
    @Override
    List<Student> selectAllObj();

    @Override
    boolean addObj(Student student);

    @Override
    boolean removeObj(int id);

    @Override
    boolean updateObj(Student student);
    // DTO
    List<StudentDTO> selectAllStudentDTO();
}
