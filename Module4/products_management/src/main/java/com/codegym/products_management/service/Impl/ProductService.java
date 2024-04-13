package com.codegym.products_management.service.Impl;

import com.codegym.products_management.model.Product;
import com.codegym.products_management.repository.IProductRepository;
import com.codegym.products_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
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
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchAllByPriceAndProductNameAndCategoryName(Double priceBefore, Double priceAfter, String productName, String categoryName, Pageable pageable) {
        return productRepository.searchAllByPriceBetweenAndProductNameContainingAndCategoryCategoryNameContaining(priceBefore, priceAfter, productName, categoryName, pageable);
    }

    @Override
    public Page<Product> searchAllByProductNameAndCategoryName(String productName, String categoryName, Pageable pageable) {
        return productRepository.searchAllByProductNameContainingAndCategoryCategoryNameContaining(productName, categoryName, pageable);
    }
}
