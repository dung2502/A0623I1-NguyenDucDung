package StudentManagement.repository;

import StudentManagement.models.Student;

public interface Repository {
    void addNewStudent(Student student);
    void removeStudent(Student student);
    void displayStudentList();
    void showTeacherInfo(int teacherId);
    Student searchStudent(String name);
    Student searchStudent(int id);
    int getSize();
    boolean isEmpty();
}
