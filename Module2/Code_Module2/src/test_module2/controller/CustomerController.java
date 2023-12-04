package test_module2.controller;

import test_module2.serviceImpl.CustomerServiceImpl;
import test_module2.model.Customer;
import test_module2.services.CustomerServices;
import test_module2.until.Validate;
import test_module2.until.Regex;


import java.util.Scanner;

public class CustomerController {
    Scanner sc = new Scanner(System.in);
    private CustomerServices services = new CustomerServiceImpl();
    public void Function(int choice ){
        switch (choice){
            case 1:
                System.out.println("----Customer----");
                services.showCustomer();
                break;
            case 2:
                addNewCustomer();
                break;
            case 3:
                editCustomer();
                break;
            case 4:
                removeCustomer();
                break;
            case 5:
               searchCustomer();
                break;
            case 6:
                System.out.println("----Read File----");
                services.readFile();
                break;
            case 7:
                System.out.println("----Write File----");
                services.writeFile();
                break;
            case 0:
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Chose number 1 -> 8 :");
                break;
        }
    }
    public void addNewCustomer(){
        System.out.println("----Add new customer----");
        System.out.print("Enter customer's name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter customer's phone: ");
        String phone = Validate.validate(Regex.phone, sc.nextLine());
        System.out.print("\nEnter customer's address: ");
        String address = sc.nextLine();
        System.out.print("\nEnter customer's email: ");
        String email = Validate.validate(Regex.email, sc.nextLine());
        System.out.print("\nEnter customer's facebook: ");
        String facebook = sc.nextLine();
        System.out.print("\nEnter customer's gender: ");
        String gender = sc.nextLine();
        System.out.print("\nEnter customer's dateOfBirth: ");
        String dateOfBirth = Validate.validate(Regex.dateOfBirth, sc.nextLine());
        System.out.print("\nEnter customer's group phone number: ");
        int groupPhoneNumber = Integer.parseInt(sc.nextLine());
        Customer customer = new Customer(name, phone, address, email, facebook, gender, dateOfBirth,
                groupPhoneNumber);
        System.out.println(services.addNew(customer) ? "Add new successfully!" : "Phone number already exists!");
    }
    public void editCustomer(){
        System.out.println("----Edit customer----");
        System.out.print("Enter phone number of customer: ");
        String phoneNumber = sc.nextLine();
        if (services.search(phoneNumber) != null){
            System.out.println("Found customer");
            Customer customer = services.search(phoneNumber);
            services.editCustomer(customer);
        } else {
            System.out.println("Customer not found!");
        }
    }
    public void removeCustomer(){
        System.out.println("----Remove customer----");
        System.out.print("Enter phone number of customer: ");
        String phoneNumber = sc.nextLine();
        if (services.search(phoneNumber) != null){
            System.out.println("----Found customer----");
            System.out.println("Are you sure you want to delete this customer? If yes, press Y, if not, press N:");
            Customer customer = services.search(phoneNumber);
            String select = sc.nextLine();
            if (select.equalsIgnoreCase("y")){
                System.out.println("You choose 'yes' Deleting!");
                services.removeCustomer(customer);
                System.out.println("The customer's name has been successfully deleted!");
            } else {
                System.out.println("You choose 'no', thank you!");
            }
        } else {
            System.out.println("Customer not found!");
        }
    }
    public void searchCustomer(){
        System.out.println("----Remove customer----");
        System.out.print("Enter phone number of customer: ");
        String phoneNumber = sc.nextLine();
        if (services.search(phoneNumber) != null){
            System.out.println("----Found customer----");
            Customer customer = services.search(phoneNumber);
            System.out.println(customer);
        } else {
            System.out.println("Customer not found!");
        }
    }


}
