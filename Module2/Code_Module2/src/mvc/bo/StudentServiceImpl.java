package mvc.bo;

import mvc.dto.Student;
import mvc.dao.StudentRepository;
import mvc.dao.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService{

    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public Student[] findAll() {
        return repository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        repository.addStudent(student);
    }
}
