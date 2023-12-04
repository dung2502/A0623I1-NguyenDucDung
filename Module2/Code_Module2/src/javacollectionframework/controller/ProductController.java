package javacollectionframework.controller;

import javacollectionframework.services.ProductService;
import javacollectionframework.serviceImpl.ProductServiceImpl;
import javacollectionframework.model.Product;

import java.util.Scanner;

public class ProductController {
    private final ProductService service = new ProductServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public void func(int select){
        switch (select){
            case 1: //Display products list
                service.displayProduct();
                break;
            case 2: //Add new product
                addNewProduct();
                break;
            case 3: //Update List
                editProduct();
                break;
            case 4: //remove
               removeProduct();
                break;
            case 5: //Search product
                searchProduct();
                break;
            case 6: //Exit
                System.exit(0);
        }
    }
    public void addNewProduct(){
        System.out.println("----Add new Product----");
        System.out.print("Enter product's name: ");
        String name = sc.nextLine();
        System.out.println("Enter product's id: ");
        String id = sc.nextLine();
        System.out.println("Enter produc's price");
        int price = sc.nextInt();
        Product product = new Product(name, id, price);
        service.addProduct(product);
    }
    public void editProduct(){
        System.out.println("----Edit ----");
        System.out.print("Enter id of product: ");
        String id = sc.nextLine();
        if (service.searchProduct(id) != null){
            System.out.println("Found product");
            Product product = service.searchProduct(id);
            service.editProduct(product);
        } else {
            System.out.println("product not found!");
        }
    }
    public void removeProduct(){
        System.out.println("----Remove product----");
        System.out.print("Enter phone number of product: ");
        String id = sc.nextLine();
        if (service.searchProduct(id) != null){
            System.out.println("----Found product----");
            System.out.println("Are you sure you want to delete this product? If yes, press Y, if not, press N:");
            Product product = service.searchProduct(id);
            String select = sc.nextLine();
            if (select.equalsIgnoreCase("y")){
                System.out.println("You choose 'yes' Deleting!");
                service.removeProduct(product);
                System.out.println("The product's name has been successfully deleted!");
            } else {
                System.out.println("You choose 'no', thank you!");
            }
        } else {
            System.out.println("product not found!");
        }
    }
    public void searchProduct(){
        System.out.println("----Remove product----");
        System.out.print("Enter phone number of product: ");
        String id = sc.nextLine();
        if (service.searchProduct(id) != null){
            System.out.println("----Found product----");
            Product product = service.searchProduct(id);
            System.out.println(product);
        } else {
            System.out.println("product not found!");
        }
    }
}