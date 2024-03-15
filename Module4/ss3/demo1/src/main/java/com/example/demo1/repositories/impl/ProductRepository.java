package com.example.demo1.repositories.impl;

import com.example.demo1.model.Product;
import com.example.demo1.repositories.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> products =new ArrayList<>();
    static {
        products.add(new Product(1, "Iphone 12 pro max", "1000", "new", "Apple"));
        products.add(new Product(2, "Iphone 13 pro max", "2000", "old( 99% )", "Apple"));
        products.add(new Product(3, "Iphone 14 pro max", "3000", "new", "Apple"));
        products.add(new Product(4, "Iphone 15 pro max", "4000", "old", "Apple"));
        products.add(new Product(5, "Iphone 16 pro max", "5000", "new", "Apple"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
