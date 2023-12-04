package StudentManagement.until;

import StudentManagement.models.Student;

import java.util.List;

public class NotFoundStudentException extends Exception{
    public NotFoundStudentException(String message) {
        super(message);
    }
    public static Student checkStudentContain(List<Student> studentList, String name){
        try {
            for (Student str: studentList){
                if (str.getName().equals(name)) {
                    return str;
                }
            }
            throw new NotFoundStudentException("Student name does not exist!");
        }
        catch (NotFoundStudentException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
