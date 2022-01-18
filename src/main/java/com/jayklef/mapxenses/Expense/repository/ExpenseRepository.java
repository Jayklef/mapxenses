package com.jayklef.mapxenses.Expense.repository;

import com.jayklef.mapxenses.Expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query(value = "select e from Expense e")
    List<Expense> findByExpensesBetween(LocalDate startDate, LocalDate endDate);

    @Query(value = "select e from Expense e")
    List<Expense> findAllExpensesBetween(LocalDate startDate, LocalDate endDate);
}
