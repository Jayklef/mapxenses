package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Category;
import com.jayklef.mapxenses.Expense.dto.CategoryDto;
import com.jayklef.mapxenses.Expense.repository.CategoryRepository;
import com.jayklef.mapxenses.Expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(CategoryDto categoryDto) {

        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Long id) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()){
            throw new CategoryNotFoundException(String.format("Category with id %d not found", id));
        }

        return categoryRepository.findById(id).get();
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category categoryInDb = categoryRepository.findById(id).get();

        if (Objects.nonNull(category.getName())&&
        !"".equalsIgnoreCase(category.getName())){
            categoryInDb.setName(category.getName());
        }

        return categoryRepository.save(categoryInDb);
    }

    @Override
    public Category findByName(String name){
       return categoryRepository.findByName(name);
    }

    @Override
    public List<Expense> findAllExpensesByCategoryId(Long id) {
        return expenseRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
