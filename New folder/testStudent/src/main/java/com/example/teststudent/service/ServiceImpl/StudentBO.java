package com.example.teststudent.service.ServiceImpl;

import com.example.teststudent.DTO.StudentDTO;
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
    public Student selectObj(int id) {
        return studentDao.selectObj(id);
    }
    @Override
    public boolean addObj(Student student) {
        return studentDao.addObj(student);
    }

    @Override
    public boolean removeObj(int id) {

        return studentDao.removeObj(id);
    }

    @Override
    public List<StudentDTO> selectAllStudentDTO() {
        return studentDao.selectAllObjDTO();
    }

    @Override
    public boolean updateObj(Student student) {
        return studentDao.updateObj(student);
    }
}
