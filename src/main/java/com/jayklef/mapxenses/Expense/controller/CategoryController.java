package com.jayklef.mapxenses.Expense.controller;

import com.jayklef.mapxenses.Expense.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Category;
import com.jayklef.mapxenses.Expense.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategoryList(){
        log.info("Inside getCategoryList of CategoryController");
        List<Category> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/categories/save")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        log.info("Inside saveCategory of CategoryController");
        Category addCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(addCategory, HttpStatus.CREATED);
    }

    @GetMapping("/categories/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        log.info("Inside getCategoryById of CategoryController");
        Category category = categoryService.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/categories/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id,
                                   @RequestBody Category category){
        log.info("Inside updateCategory of CategoryController");
        Category updateCategory = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/categories/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id){
        log.info("Inside deleteCategory of CategoryController");
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
