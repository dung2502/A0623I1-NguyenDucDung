package FuramaResort.controllers;
import java.util.Scanner;
public class FuramaController {
    static Scanner sc = new Scanner(System.in);
   public static void displayMainMenu(){
       int select;
       do{
           System.out.println("1. Employee Management");
           System.out.println("2. Customer Management");
           System.out.println("3. Facility Management");
           System.out.println("4. Booking Management");
           System.out.println("5. Promotion Management");
           System.out.println("6. Exit");

           select = sc.nextInt();

           switch (select){
               case 1:
                   System.out.println("Employee Management");
                   displayEmployeeManagement();
                   break;
               case 2:
                   System.out.println("Customer Management");
                   displayCustomerManagement();
                   break;
               case 3:
                   System.out.println("Facility Management");
                   displayFacilityManagement();
                   break;
               case 4:
                   System.out.println("Booking Management");
                   displayBookingManagement();
                   break;
               case 5:
                   System.out.println("Promotion Management");
                   displayPromotionManagement();
                   break;
               case 6:
                   System.exit(0);
                   break;

           }
       }
       while(true);

    }
    public static void displayEmployeeManagement(){
        int select;
        do{
           System.out.println("1. Display list employees");
           System.out.println("2. Add new employee");
           System.out.println("3. Edit employee");
           System.out.println("4. Return main menu");

            select = sc.nextInt();
           switch (select){
               case 1:
                   System.out.println("Show list employees");
                   break;
               case 2:
                   System.out.println("New employees");
                   break;
               case 3:
                   System.out.println("Edit employees");
                   break;
               case 4:
                   displayMainMenu();
           }
       }
       while(true);
    }

    public static void displayCustomerManagement(){
        int select;
       do {
           System.out.println("1. Display list customers");
           System.out.println("2. Add new customer");
           System.out.println("3. Edit customer");
           System.out.println("4. Return main menu");

            select = sc.nextInt();
           switch (select){
               case 1:
                   System.out.println("Show list customers");
                   break;
               case 2:
                   System.out.println("New employees");
                   break;
               case 3:
                   System.out.println("Edit employees");
               case 4:
                   displayMainMenu();
           }
       }
       while (true);

    }

    public static void displayFacilityManagement(){
        int select;
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");

             select = sc.nextInt();
            switch (select){
                case 1:
                    System.out.println("Show list facility");
                    break;
                case 2:
                    System.out.println("New facility");
                    break;
                case 3:
                    System.out.println("Show list facility maintenance");
                case 4:
                    displayMainMenu();
            }
        }
        while (true);

    }

    public static void displayBookingManagement(){
        int select;
        do {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");

             select = sc.nextInt();
            switch (select){
                case 1:
                    System.out.println("Add new booking");
                    break;
                case 2:
                    System.out.println("Display list booking");
                    break;
                case 3:
                    System.out.println("Create new contracts");
                    break;
                case 4:
                    System.out.println("Display list contracts");
                    break;
                case 5:
                    System.out.println("Edit contracts");
                    break;
                case 6:
                    displayMainMenu();
            }
        }
        while (true);

    }

    public static void displayPromotionManagement(){
        int select;
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");

            select = sc.nextInt();
            switch (select){
                case 1:
                    System.out.println("Show list customers use service");
                    break;
                case 2:
                    System.out.println("Show list customers get voucher");
                    break;
                case 3:
                    displayMainMenu();
            }
        }
        while (true);

    }
}
