package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.model.Category;
import com.jayklef.mapxenses.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category updateCategory(Long id) {
        Category category = categoryRepository.findById(id).get();

        return categoryRepository.findById(id).get();
    }
}
