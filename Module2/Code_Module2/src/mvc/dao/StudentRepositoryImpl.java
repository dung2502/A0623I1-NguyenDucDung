package mvc.dao;

import mvc.dto.Student;


public class StudentRepositoryImpl implements StudentRepository{
    //kết nối DB
    private static Student[] studentList;
    private static int size = 0;

    static {
        studentList = new Student[10];
        studentList[0] = new Student(1, "Nguyen Van A");
        studentList[1] = new Student(2, "Nguyen Van B");
        studentList[2] = new Student(3, "Nguyen Van C");
        size = 3;
    }

    @Override
    public Student[] findAll() {
        Student[] students = new Student[size];
        for(int i = 0; i < size; i++){
            students[i] = studentList[i];
        }
        return students;
    }

    @Override
    public void addStudent(Student student) {
        /*
        Kiểm tra size > 10
        ...
         */

        //thêm mới
        studentList[size] = student;
        size++;
    }
}
