package com.example.demo1.repositories;

import com.example.demo1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
}
