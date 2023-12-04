package StudentManagement.serviceImpl;

import StudentManagement.models.Student;
import StudentManagement.repository.Repository;
import StudentManagement.repositoryIpml.RepositoryImpl;
import StudentManagement.service.Service;
import StudentManagement.until.Regex;
import StudentManagement.until.Validate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceImpl implements Service {
    static Scanner sc = new Scanner(System.in);
    private final Repository repository = new RepositoryImpl();
    @Override
    public void addNewStudent() {
        try {
            int id = repository.getSize() + 1;
            System.out.print("Enter name of student: ");
            String name = Validate.validate(Regex.STUDENT_NAME, sc.nextLine());
            System.out.print("\nEnter student's born: ");
            String born = Validate.validate(Regex.STUDENT_BORN, sc.nextLine());
            System.out.println("\nEnter student' gender: ");
            String gender = sc.nextLine();
            System.out.println("\nEnter student's phone number: ");
            String phoneNumber = Validate.validate(Regex.PHONENUMBER, sc.nextLine());
            System.out.println("Enter class id: ");
            int classId = Integer.parseInt(sc.nextLine());
            Student student = new Student(id, name, born, gender, phoneNumber, classId);
            repository.addNewStudent(student);
        }
        catch (InputMismatchException e){
            System.out.println("Please enter a integer!");
        }
    }

    @Override
    public Student removeStudent(int id) {
        Student student = repository.searchStudent(id);
        if (student != null){
            System.out.println("Student found! Let's enter 'Y' for remove student or 'N' for exit function!");
            String select = sc.nextLine();
            if (select.toLowerCase().equals("y")){
                repository.removeStudent(student);
                return student;
            }
        }
        return null;
    }

    @Override
    public void displayStudentList() {
        if (repository.isEmpty()){
            System.out.println("Student's list is empty!");
        } else {
            repository.displayStudentList();
        }
    }


    @Override
    public void showTeacherInfo(int teacherId) {
        repository.showTeacherInfo(teacherId);
    }

    @Override
    public Student searchStudent(String name) {
        return repository.searchStudent(name);
    }
}
