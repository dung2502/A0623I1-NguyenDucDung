package thi_module2.service;

import thi_module2.model.Student;

import java.util.List;

public interface Service {
    void addNewStudent(Student student);
    void deleteStudent(Student student);
    void showStudent();
    void showTeacher();
    Student searchStudent(String name);
    Student search(int id);
}
