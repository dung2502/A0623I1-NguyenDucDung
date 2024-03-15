package com.example.demo1.services;

import com.example.demo1.model.Product;

import java.util.List;

public interface IProductServices {
    List<Product> findAll();

    void save(Product product);
}
