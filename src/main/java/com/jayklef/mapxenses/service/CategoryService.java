package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList();

    Category saveCategory(Category category);

    Category getCategoryById(Long id) throws CategoryNotFoundException;

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
