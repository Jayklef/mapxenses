package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.exception.CategoryNotFoundException;
import com.jayklef.mapxenses.Expense.model.Category;
import com.jayklef.mapxenses.Expense.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Long id) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);

        if (id == null){
            throw new CategoryNotFoundException("Category Not Found");
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

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
