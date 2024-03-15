package com.example.teststudent.repository;

import com.example.teststudent.model.Teacher;

import java.util.List;

public interface ITeacherDao extends IRepository<Teacher>{
    @Override
    List<Teacher> selectAllObj();

    @Override
    Teacher selectObj(int id);

    @Override
    boolean addObj(Teacher teacher);

    @Override
    boolean removeObj(int id);

    @Override
    boolean updateObj(Teacher teacher);
}
