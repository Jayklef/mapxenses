package com.jayklef.mapxenses.controller;

import com.jayklef.mapxenses.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.model.Expense;
import com.jayklef.mapxenses.service.ExpenseService;
import com.jayklef.mapxenses.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getExpenseList(){
        log.info("Inside getExpenseList of ExpenseController");
        return expenseService.getExpenseList();
    }

    @PostMapping("/expenses")
    public Expense saveExpense(@RequestBody Expense expense){
        log.info("Inside saveExpense of ExpenseController");
        return expenseService.saveExpense(expense);
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long expenseId) throws ExpenseNotFoundException {
        log.info("Inside getExpenseById of ExpenseController");
        return expenseService.getExpenseById(expenseId);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpense(@PathVariable("id")Long expenseId,
                                 @RequestBody Expense expense){
        log.info("Inside updateExpense of ExpenseController");
        return expenseService.updateExpense(expenseId, expense);
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return "Expense deleted successfully";
    }

    public BigDecimal calculateWeeklyExpenses(String startDate, String endDate){
        return expenseService.calculateWeeklyExpenses(startDate, endDate);
    }
}
