package com.example.products_project.service;

import com.example.products_project.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    void save(Category category);
    void delete(Integer id);
}
