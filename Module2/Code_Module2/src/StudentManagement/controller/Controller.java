package StudentManagement.controller;

import StudentManagement.models.Student;
import StudentManagement.service.Service;
import StudentManagement.serviceImpl.ServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    static Scanner sc = new Scanner(System.in);
    private final Service service = new ServiceImpl();
    public void displayMainMenu(){
        int select;
        do{
            try {
                System.out.println("----STUDENT MANAGEMENT PROGRAMMING----"
                        + "\nPlease choose a item to continue: "
                        + "\n1. Add new student"
                        + "\n2. Remove student"
                        + "\n3. Display student list"
                        + "\n4. Show teacher's info"
                        + "\n5. Searching student"
                        + "\n6. Exit");
                select = Integer.parseInt(sc.nextLine());
                switch (select){
                    case 1:
                        System.out.println("----Add new student----");
                        service.addNewStudent();
                        break;
                    case 2:
                        System.out.println("----Remove student----");
                        System.out.print("Enter id of student you want to search: ");
                        int id = Integer.parseInt(sc.nextLine());
                        service.removeStudent(id);
                        break;
                    case 3:
                        System.out.println("Student list");
                        service.displayStudentList();
                        break;
                    case 4:
                        System.out.println("Show teacher's info");
                        System.out.println("Enter id of teacher: ");
                        int teacherId = Integer.parseInt(sc.nextLine());
                        service.showTeacherInfo(teacherId);
                        break;
                    case 5:
                        System.out.println("Searching student: ");
                        System.out.println("Enter name of student you want to searching: ");
                        String name = sc.nextLine();
                        Student student = service.searchStudent(name);
                        if (student != null){
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    case 6:
                        System.out.println("Exit program!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please choose a number 1-6: ");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.displayMainMenu();
    }
}
