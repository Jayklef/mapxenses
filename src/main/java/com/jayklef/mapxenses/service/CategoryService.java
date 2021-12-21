package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList();

    Category saveCategory(Category category);

    Category getCategoryById(Long id);
}
