package com.jayklef.mapxenses.Expense.utils;

import com.jayklef.mapxenses.Expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;


public class Utility {

    @Autowired
    private ExpenseService expenseService;

    public ResponseEntity<Double> calculateWeeklyExpenses(LocalDate startDate, LocalDate endDate) {
        Double expenses = expenseService.calculateWeeklyExpenses(startDate, endDate);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

}