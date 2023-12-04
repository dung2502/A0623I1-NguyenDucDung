package thi_module2.view;

import thi_module2.controller.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner(System.in);
    private static final Controller controller = new Controller();
    public static void displayMainMenu(){
        int select;
        do{
            try {
                System.out.println("----STUDENT MANAGEMENT PROGRAM----");
                System.out.println("1. Add new student");
                System.out.println("2. Delete student");
                System.out.println("3. Show student");
                System.out.println("4. Show teacher");
                System.out.println("5. Search student");
                System.out.println("0. Exit");
                System.out.println(" Please choose the function: ");
                select = sc.nextInt();
                controller.Function(select);
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
