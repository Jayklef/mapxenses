package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getExpenseList();

    Expense saveExpense(Expense expense);

    Expense getExpenseById(Long id);

    Expense updateExpense(Expense expense);

    void deleteExpense(Long id);
}
