package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {
    Expense saveExpense(Expense expense);

    Expense updateExpense(Long expenseId, Expense expense);

    void deleteExpense(Long expenseId);

    List<Expense> findExpenseList();

    Expense findExpenseById(Long expenseId) throws ExpenseNotFoundException;

    Double calculateWeeklyExpenses(LocalDate startDate, LocalDate endDate);

    Double calculateMonthlyExpenses(LocalDate startDate, LocalDate endDate);
}
