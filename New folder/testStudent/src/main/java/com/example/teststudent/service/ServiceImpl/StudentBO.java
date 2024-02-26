package com.example.teststudent.service.ServiceImpl;

import com.example.teststudent.model.Student;
import com.example.teststudent.repository.IStudentDao;
import com.example.teststudent.repository.RepositoryImpl.StudentDao;
import com.example.teststudent.service.IStudentBO;

import java.util.List;

public class StudentBO implements IStudentBO {
    private IStudentDao studentDao = new StudentDao();
    @Override
    public List<Student> selectAllObj() {
        return studentDao.selectAllObj();
    }

    @Override
    public Student electObj(int id) {
        return null;
    }

    @Override
    public boolean addObj(Student student) {
        return false;
    }

    @Override
    public boolean removeObj(int id) {
        return false;
    }

    @Override
    public boolean updateObj(Student student) {
        return false;
    }
}
