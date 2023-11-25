package io_binary_file.product.view;

import io_binary_file.product.bo.ProductService;
import io_binary_file.product.bo.ProductServiceImpl;
import io_binary_file.product.controller.ProductController;

import java.util.Scanner;

public class Main {
    private static final ProductController controller = new ProductController();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select;
        do {
            System.out.println(" Product Manager ");
            System.out.println("1. Show Product");
            System.out.println("2. Add new Product");
            System.out.println("3. Update List Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Search Product");
            System.out.println("6. Exit");
            System.out.println("Input your choice : ");
            select = sc.nextInt();
            controller.function(select);
        } while(true);
    }

}
