package com.example.teststudent.repository;

import com.example.teststudent.model.Classes;

import java.util.List;

public interface IClassesDao extends IRepository<Classes>{
    @Override
    List<Classes> selectAllObj();

    @Override
    Classes selectObj(int id);

    @Override
    boolean addObj(Classes classes);

    @Override
    boolean removeObj(int id);

    @Override
    boolean updateObj(Classes classes);
}
