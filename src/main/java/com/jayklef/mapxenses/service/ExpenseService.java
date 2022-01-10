package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.model.Expense;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExpenseService {
    Expense saveExpense(Expense expense);

    Expense updateExpense(Long expenseId, Expense expense);

    void deleteExpense(Long expenseId);

    List<Expense> findExpenseList();

    Expense findExpenseById(Long expenseId) throws ExpenseNotFoundException;
}
