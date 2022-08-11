package com.jayklef.mapxenses.Expense.controller;

import com.jayklef.mapxenses.Expense.dto.ExpenseToCategoryDto;
import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Category;
import com.jayklef.mapxenses.Expense.dto.CategoryDto;
import com.jayklef.mapxenses.Expense.service.CategoryService;
import com.jayklef.mapxenses.Expense.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ExpenseService expenseService;


    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategoryList(){
        log.info("Inside getCategoryList of CategoryController");
        List<Category> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Expense>> findAllExpenseByCategory(@PathVariable("id") Long id){
        List<Expense> expenses = categoryService.findAllExpensesByCategoryId(id);
        return new ResponseEntity<>(expenses, HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto){
        log.info("Inside saveCategory of CategoryController");

        Category addCategory = categoryService.saveCategory(categoryDto);
        return new ResponseEntity(addCategory, HttpStatus.CREATED);
    }

    @PostMapping("/expensename")
    public ResponseEntity<?> addExpenseToCategory(@RequestBody ExpenseToCategoryDto expense){
        categoryService.addExpenseToCategory(expense.getCategoryName(), expense.getExpenseName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        log.info("Inside getCategoryById of CategoryController");
        Category category = categoryService.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id,
                                   @RequestBody Category category){
        log.info("Inside updateCategory of CategoryController");
        Category updateCategory = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id){
        log.info("Inside deleteCategory of CategoryController");
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
