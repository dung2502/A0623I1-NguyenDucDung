package io_binary_file.product.controller;

import io_binary_file.product.bo.ProductService;
import io_binary_file.product.bo.ProductServiceImpl;
import io_binary_file.product.dto.Product;

import java.util.Scanner;

public class ProductController {
    private final ProductService service = new ProductServiceImpl();

    public void function(int select){
        Scanner sc = new Scanner(System.in);
        switch (select){
            case 1: // Show
                service.showProduct();
                break;
            case 2: // Add new Product
                System.out.println("Add id product: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.println("Add name product: ");
                String name = sc.nextLine();
                System.out.println("Add producer product: ");
                String producer = sc.nextLine();
                System.out.println("Add salary product: ");
                int salary =Integer.parseInt(sc.nextLine());
                System.out.println("Add describe product: ");
                String describe = sc.nextLine();
                Product product = new Product(id,name,producer,salary,describe);
                service.addProduct(product);
                break;
            case 3: //Update List
                System.out.println("Input ID Product you want to update: ");
                 int idUpdate = sc.nextInt();
                 service.setProduct(idUpdate);
                 break;
            case 4: //remove
                System.out.println("Input ID Product you want remove:  ");
                int idRemove = sc.nextInt();
                service.removeProduct(idRemove);
                break;
            case 5:// Search Product
                System.out.println("Input Product name you want search: ");
                String nameSearch = sc.nextLine();
                service.searchProduct(nameSearch);
                break;
            case 6:// Exit
                System.exit(0);

        }
    }


}
