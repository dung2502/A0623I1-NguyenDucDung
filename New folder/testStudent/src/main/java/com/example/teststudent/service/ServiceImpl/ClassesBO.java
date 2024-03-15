package com.example.teststudent.service.ServiceImpl;

import com.example.teststudent.model.Classes;
import com.example.teststudent.repository.IClassesDao;
import com.example.teststudent.repository.RepositoryImpl.ClassDao;
import com.example.teststudent.service.IClassBO;

import java.util.List;

public class ClassesBO implements IClassBO {
    private IClassesDao classDAO = new ClassDao();
    @Override
    public List<Classes> selectAllObj() {
        return classDAO.selectAllObj();
    }

    @Override
    public Classes selectObj(int id) {
        return null;
    }

    @Override
    public boolean addObj(Classes classes) {
        return false;
    }

    @Override
    public boolean removeObj(int id) {
        return false;
    }

    @Override
    public boolean updateObj(Classes classes) {
        return false;
    }
}
