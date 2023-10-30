package mvc.controller;

import mvc.dto.Student;
import mvc.bo.StudentService;
import mvc.bo.StudentServiceImpl;

import java.util.Scanner;

public class StudentController {
    private static StudentService service = new StudentServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("-----Student System--------");
            System.out.println("1. List");
            System.out.println("2. Add new");
            System.out.println("3. Update");
            System.out.println("9. Exit");
            System.out.print("Please input number: ");
            select = Integer.parseInt(scanner.nextLine());
            switch (select){
                case 1: //list
                    Student[] students = service.findAll();
                    for(Student student: students){
                        System.out.println(student);
                    }
                    break;
                case 2: //add new
                    System.out.print("Input id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Input name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(id, name);

                    service.addStudent(student);
                    break;
                case 3: //update
                    break;
                case 9:// exit
                    System.exit(0);
            }
        } while (true);
    }

}
