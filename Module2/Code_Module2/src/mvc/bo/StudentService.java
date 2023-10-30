package mvc.bo;

import mvc.dto.Student;

public interface StudentService {
    /* CRUD */
    Student[] findAll();

    void addStudent(Student student);

    /* validation
    * kiểm tra dữ liệu đầu vào - min/mx
    * kiểm tra trùng
    * */
}
