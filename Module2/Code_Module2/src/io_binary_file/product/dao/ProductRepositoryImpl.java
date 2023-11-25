package io_binary_file.product.dao;

import io_binary_file.product.dto.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ProductRepositoryImpl implements ProductRepository {
    Scanner sc = new Scanner(System.in);
    private static final ArrayList<Product> ProductsArray = new ArrayList<>();
    static {
        ProductsArray.add(new Product(1,"Iphone 12","Apple",200000,"stocking"));
        ProductsArray.add(new Product(2,"Iphone 13","Apple",300000,"out of stock"));
        ProductsArray.add(new Product(3,"Iphone 14","Apple",400000,"stocking"));
        ProductsArray.add(new Product(4,"Iphone 15","Apple",500000,"out of stock"));
    }

    @Override
    public int getSize() {

        return ProductsArray.size();
    }

    @Override
    public void addProduct(Product product) {

        ProductsArray.add(product);
    }
    @Override
    public void setProduct(int id) {
        Product product = SearchProductById(id);
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the id you want to edit: ");
                int idEdit = sc.nextInt();
                product.setId(idEdit);
                break;
            case 2:
                System.out.println("Enter the name you want to edit: ");
                String nameEdit =  sc.nextLine();
                product.setName(nameEdit);
                break;
            case 3:
                System.out.println("Enter the salary you want to edit: ");
                int salaryEdit =  sc.nextInt();
                product.setSalary(salaryEdit);
                break;
        }
    }
    @Override
    public void showProduct() {
        sortProductList();
        for (Product product: ProductsArray){
            System.out.println(product);
        }
    }

    @Override
    public Product removeProduct(int id) {
        Product product = SearchProductById(id);
        int index = ProductsArray.indexOf(product);
        return ProductsArray.remove(index);

    }

    @Override
    public Product searchProduct(String name) {
        for (Product product: ProductsArray){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
    @Override
    public Product SearchProductById(int id) {
        for (Product product : ProductsArray) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void sortProductList() {
        Collections.sort(ProductsArray);
    }
}
