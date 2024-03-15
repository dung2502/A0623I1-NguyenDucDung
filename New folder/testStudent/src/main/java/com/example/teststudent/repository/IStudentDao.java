package com.example.teststudent.repository;

import com.example.teststudent.DTO.StudentDTO;
import com.example.teststudent.model.Student;

import java.util.List;

public interface IStudentDao extends IRepository<Student> {
    @Override
    List<Student> selectAllObj();


    List<StudentDTO> selectAllObjDTO();

    @Override
    Student selectObj(int id);

    @Override
    boolean addObj(Student student);

    @Override
    boolean removeObj(int id);

    @Override
    boolean updateObj(Student student);
}
