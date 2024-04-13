package com.codegym.products_management.service;

import com.codegym.products_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void save(Product product);

    void remove(Integer id);
    Page<Product> searchAllByPriceAndProductNameAndCategoryName(Double priceBefore, Double priceAfter, String productName, String categoryName, Pageable pageable);
    Page<Product> searchAllByProductNameAndCategoryName(String productName, String categoryName, Pageable pageable);
}
