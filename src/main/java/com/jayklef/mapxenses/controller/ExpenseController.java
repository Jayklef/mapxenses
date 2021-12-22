package com.jayklef.mapxenses.controller;

import com.jayklef.mapxenses.model.Expense;
import com.jayklef.mapxenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getExpenseList(){
        return expenseService.getExpenseList();
    }

    @PostMapping("/expenses")
    public Expense saveExpense(@RequestBody Expense expense){
        return expenseService.saveExpense(expense);
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id){
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpense(@PathVariable("id")Long id,
                                 @RequestBody Expense expense){
        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable("id") Long id){
        expenseService.deleteExpense(id);
        return "Expense deleted successfully";
    }
}
