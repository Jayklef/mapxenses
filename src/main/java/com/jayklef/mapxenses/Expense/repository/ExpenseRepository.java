package com.jayklef.mapxenses.Expense.repository;

import com.jayklef.mapxenses.Expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query(value = "SELECT q From Expense q ")
    List<Expense> findByExpensesBetween(LocalDate startDate, LocalDate endDate);
}
