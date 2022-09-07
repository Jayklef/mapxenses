package com.jayklef.mapxenses.Expense.controller;

import com.jayklef.mapxenses.Expense.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.dto.ExpenseDto;
import com.jayklef.mapxenses.Expense.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/save")
    public ResponseEntity<Expense> saveExpense(@RequestBody ExpenseDto expenseDto){
        Expense newExpense = expenseService.saveExpense(expenseDto);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getExpenseList(){
        log.info("Inside getExpenseList of ExpenseController");
        List<Expense> expenses = expenseService.findExpenseList();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Long expenseId) throws ExpenseNotFoundException {
        log.info("Inside getExpenseById of ExpenseController");
        Expense expense = expenseService.findExpenseById(expenseId);
        return new ResponseEntity<>(expense, HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id")Long expenseId,
                                 @RequestBody Expense expense){
        log.info("Inside updateExpense of ExpenseController");
        Expense updateExpense = expenseService.updateExpense(expenseId, expense);
        return new ResponseEntity<>(updateExpense, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        log.info("Inside updateExpense of ExpenseController");
        expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<Expense> getByName(String name){
        Expense expense = expenseService.findByName(name);
        log.info("getting expense by name :{}", expense.getName());
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @GetMapping("/weekly")
    public ResponseEntity<Double> calculateWeeklyExpenses(LocalDate startDate, LocalDate endDate) {
        Double expenses = expenseService.calculateWeeklyExpenses(startDate, endDate);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/monthly")
    public ResponseEntity<Double> monthlyExpenses(LocalDate startDate, LocalDate endDate){
        Double monthlyExpenses = expenseService.calculateMonthlyExpenses(startDate, endDate);
        return new ResponseEntity<>(monthlyExpenses, HttpStatus.OK);
    }
}
