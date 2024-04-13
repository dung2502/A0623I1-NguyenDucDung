package com.codegym.shoppingcart.service;

import com.codegym.shoppingcart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Page<Product> searchAllByName(String name, Pageable pageable);
    void save(Product product);
    void remove(Long id);
}
