package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.model.Expense;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExpenseService {
    List<Expense> getExpenseList();

    Expense saveExpense(Expense expense);

    Expense getExpenseById(Long expenseId) throws ExpenseNotFoundException;

    Expense updateExpense(Long expenseId, Expense expense);

    void deleteExpense(Long expenseId);
}
