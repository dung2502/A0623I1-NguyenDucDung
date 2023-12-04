package test_module2.view;

import test_module2.controller.CustomerController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static final CustomerController controller = new CustomerController();
    public static void displayMainMenu(){
        int select;
        do{
            try {
                System.out.println("----PHONEBOOK MANAGEMENT PROGRAM----");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Remove customer");
                System.out.println("5. Search customer");
                System.out.println("6. Read from customer's file");
                System.out.println("7. Write to customer's file");
                System.out.println("0. Exit");
                System.out.println(" Please choose the function: ");
                select = Integer.parseInt(sc.nextLine());
                controller.Function(select);
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
            }
            catch (NumberFormatException e){
                System.out.println("Don't enter characters, enter numbers!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
