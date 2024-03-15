package com.example.demo1.services.impl;

import com.example.demo1.model.Product;
import com.example.demo1.repositories.IProductRepository;
import com.example.demo1.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServices implements IProductServices {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }
}
