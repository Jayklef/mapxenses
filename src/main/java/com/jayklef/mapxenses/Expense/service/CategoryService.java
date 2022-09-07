package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.dto.ExpenseDto;
import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Category;
import com.jayklef.mapxenses.Expense.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    Category saveCategory(CategoryDto categoryDto);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    List<Category> findAllCategories();

    Category findCategoryById(Long id)throws CategoryNotFoundException;

    List<Expense> findAllExpensesByCategoryId(Long id);

    Category findByName(String name);

    void addExpenseToCategory(String name, String expenseName);
}
