package thi_module2.controller;


import thi_module2.model.Student;
import thi_module2.service.Service;
import thi_module2.seviceImpl.ServiceImpl;
import thi_module2.until.Regex;
import thi_module2.until.Validate;

import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);
    private  Service services = new ServiceImpl();
    public void Function(int choice ){
        switch (choice){
            case 1:
              //add student
                addNewStudent();
                break;
            case 2:
               //remove student
                removeStudent();
                break;
            case 3:
               //show student
                services.showStudent();
                break;
            case 4:
               // show teacher
                services.showTeacher();
                break;
            case 5:
                //search student
                searchStudent();
                break;
            case 0:
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Chose number 1 -> 5 :");
                break;
        }
    }
    public void addNewStudent(){
        System.out.println("----Add new Student----");
        System.out.print("\nEnter student's id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter student's name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter student's gender: ");
        String gender = sc.nextLine();
        System.out.print("\nEnter student's number phone: ");
        String numberPhone = Validate.validate(Regex.phone, sc.nextLine());
        System.out.print("\nEnter ID class: ");
        String idClass = sc.nextLine();
        Student student = new Student(id, name, "",gender,numberPhone,idClass);
        services.addNewStudent(student);
    }

    public void removeStudent(){
        System.out.println("----Remove student----");
        System.out.print("Enter id of student: ");
        int id = Integer.parseInt(sc.nextLine());
        if (services.search(id) != null){
            System.out.println("----Found Student----");
            System.out.println("Are you sure you want to delete this student? If yes, press Y, if not, press N:");
            Student student = services.search(id);
            String select = sc.nextLine();
            if (select.equalsIgnoreCase("y")){
                System.out.println("You choose 'yes' Deleting!");
                services.deleteStudent(student);
                System.out.println("The student's name has been successfully deleted!");
            } else {
                System.out.println("You choose 'no', thank you!");
            }
        } else {
            System.out.println("student not found!");
        }
    }
    public void searchStudent(){
        System.out.println("----Search student----");
        System.out.print("Enter name of student: ");
        String name = sc.nextLine();
        if (services.searchStudent(name) != null){
            System.out.println("----Found student----");
            Student customer = services.searchStudent(name);
            System.out.println(customer);
        } else {
            System.out.println("Student not found!");
        }
    }


}
