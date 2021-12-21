package com.jayklef.mapxenses.controller;

import com.jayklef.mapxenses.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.model.Category;
import com.jayklef.mapxenses.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategoryList(){
        return categoryService.getCategoryList();
    }

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable("id") Long id,
                                   @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "Category Removed Successfully";
    }
}
