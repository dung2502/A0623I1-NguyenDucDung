package com.example.teststudent.repository.RepositoryImpl;

import com.example.teststudent.model.Classes;
import com.example.teststudent.model.Student;
import com.example.teststudent.repository.BaseDao;
import com.example.teststudent.repository.IClassesDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDao implements IClassesDao {
    private static final String Select_All_Classes = " select * from classes;";

    @Override
    public List<Classes> selectAllObj() {

        List<Classes> classesList = new ArrayList<>();
        Classes classes;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Select_All_Classes);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                classes = new Classes();
                classes.setClassId(rs.getInt("classId"));
                classes.setNameClass(rs.getString("className"));
                classes.setTeacherId(rs.getInt("teacherId"));
                classesList.add(classes);
            }
            return classesList;
        } catch (SQLException e) {
            System.out.println("Error connecting to database!");
            e.printStackTrace();
        }
        return classesList;
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
