package com.codegym.products_management.repository;

import com.codegym.products_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> searchAllByPriceBetweenAndProductNameContainingAndCategoryCategoryNameContaining(double priceBefore, double priceAfterString, String productName, String categoryName, Pageable pageable);
    Page<Product> searchAllByProductNameContainingAndCategoryCategoryNameContaining(String productName, String categoryName, Pageable pageable);
}
