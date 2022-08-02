package com.jayklef.mapxenses.Expense.controller;

import com.jayklef.mapxenses.Expense.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getExpenseList(){
        log.info("Inside getExpenseList of ExpenseController");
        List<Expense> expenses = expenseService.findExpenseList();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping("/expenses/save")
    public ResponseEntity<Expense> newExpense(@RequestBody Expense expense){
        log.info("Inside saveExpense of ExpenseController");
        Expense newExpense = expenseService.saveExpense(expense);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }

    @GetMapping("/expenses/find/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Long expenseId) throws ExpenseNotFoundException {
        log.info("Inside getExpenseById of ExpenseController");
        Expense expense = expenseService.findExpenseById(expenseId);
        return new ResponseEntity<>(expense, HttpStatus.FOUND);
    }

    @PutMapping("/expenses/update/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id")Long expenseId,
                                 @RequestBody Expense expense){
        log.info("Inside updateExpense of ExpenseController");
        Expense updateExpense = expenseService.updateExpense(expenseId, expense);
        return new ResponseEntity<>(updateExpense, HttpStatus.OK);
    }

    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        log.info("Inside updateExpense of ExpenseController");
        expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
