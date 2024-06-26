package com.example.products_project.repository;

import com.example.products_project.model.Product;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> searchAllByPriceBetweenAndProductNameContainingAndCategoryCategoryNameContaining(Double priceBefore, Double priceAfter, String productName, String categoryName, Pageable pageable);
    Page<Product> searchAllByProductNameContainingAndCategoryCategoryNameContaining(String productName, String categoryName, Pageable pageable);
}
