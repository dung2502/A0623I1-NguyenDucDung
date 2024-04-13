package com.example.products_project.service.impl;

import com.example.products_project.model.Product;
import com.example.products_project.repository.IProductRepository;
import com.example.products_project.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
    productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
    productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchAllProductByPriceAndProductName(Double priceBefore, Double priceAfter, String productName, String categoryName, Pageable pageable) {
        return productRepository.searchAllByPriceBetweenAndProductNameContainingAndCategoryCategoryNameContaining(priceBefore, priceAfter, productName, categoryName, pageable);
    }

    @Override
    public Page<Product> searchAllProductByProductNameAndCategoryName(String productName, String categoryName, Pageable pageable) {
        return productRepository.searchAllByProductNameContainingAndCategoryCategoryNameContaining(productName,categoryName,pageable);
    }

}
