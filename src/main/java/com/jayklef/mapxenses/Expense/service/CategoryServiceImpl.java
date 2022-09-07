package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.dto.ExpenseDto;
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
    public Expense saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setDescription(expenseDto.getDescription());
        expense.setExpenseDate(expenseDto.getExpenseDate());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategory(expenseDto.getCategory());

        return expenseRepository.save(expense);
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
    public List<Expense> findAllExpensesByCategoryId(Long id) {

        Optional<Category> category = categoryRepository.findById(id);

        if (!category.isPresent()){
            throw new RuntimeException(String.format("Category with id %d not found" + id));
        }

        return category.get().getExpenses()
                .stream()
                .sorted(Comparator.comparing(Expense::getAmount))
                .collect(Collectors.toList());
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
    public void addExpenseToCategory(String name, String expenseName) {
        Category category = categoryRepository.findByName(name);
        Expense expense = expenseRepository.findByName(expenseName);
        category.getExpenses().add(expense);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
