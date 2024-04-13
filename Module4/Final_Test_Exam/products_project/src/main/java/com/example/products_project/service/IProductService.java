package com.example.products_project.service;

import com.example.products_project.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void save(Product product);
    void delete(Integer id);
    Page<Product> searchAllProductByPriceAndProductName(Double priceBefore, Double priceAfter, String productName, String categoryName, Pageable pageable);
    Page<Product> searchAllProductByProductNameAndCategoryName(String productName, String categoryName, Pageable pageable);

}
