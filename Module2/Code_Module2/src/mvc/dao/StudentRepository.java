package mvc.dao;

import mvc.dto.Student;

public interface StudentRepository {
    Student[] findAll();

    void addStudent(Student student);
}
