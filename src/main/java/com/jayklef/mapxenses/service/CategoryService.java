package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.model.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    List<Category> findAllCategories();

    Category findCategoryById(Long id)throws CategoryNotFoundException;
}
