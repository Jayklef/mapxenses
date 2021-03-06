package com.jayklef.mapxenses.Expense.repository;

import com.jayklef.mapxenses.Expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
