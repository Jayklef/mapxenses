package com.jayklef.mapxenses.controller;

import com.jayklef.mapxenses.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.model.Category;
import com.jayklef.mapxenses.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategoryList(){
        log.info("Inside getCategoryList of CategoryController");
        return categoryService.getCategoryList();
    }

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category){
        log.info("Inside saveCategory of CategoryController");
        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        log.info("Inside getCategoryById of CategoryController");
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable("id") Long id,
                                   @RequestBody Category category){
        log.info("Inside updateCategory of CategoryController");
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        log.info("Inside deleteCategory of CategoryController");
        categoryService.deleteCategory(id);
        return "Category Removed Successfully";
    }
}
