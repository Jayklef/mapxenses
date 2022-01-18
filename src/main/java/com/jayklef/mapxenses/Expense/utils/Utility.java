package com.jayklef.mapxenses.Expense.utils;

import com.jayklef.mapxenses.Expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


public class Utility {

    @Autowired
    private ExpenseService expenseService;

    public ResponseEntity<Double> calculateWeeklyExpenses(LocalDate startDate, LocalDate endDate) {
        Double expenses = expenseService.calculateWeeklyExpenses(startDate, endDate);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    public ResponseEntity<Double> monthlyExpenses(LocalDate startDate, LocalDate endDate){
        List<Double> monthlyExpenses = Collections.singletonList(expenseService.calculateMonthlyExpenses(startDate, endDate));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}