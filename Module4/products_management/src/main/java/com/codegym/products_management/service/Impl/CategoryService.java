package com.codegym.products_management.service.Impl;

import com.codegym.products_management.model.Category;
import com.codegym.products_management.repository.ICategoryRepository;
import com.codegym.products_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }
}
