package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Category;
import com.jayklef.mapxenses.Expense.model.CategoryModel;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    Category saveCategory(CategoryModel categoryModel);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    List<Category> findAllCategories();

    Category findCategoryById(Long id)throws CategoryNotFoundException;

    List<Expense> findAllExpensesByCategoryId(Long id);
}
