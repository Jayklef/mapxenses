package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.model.Expense;
import com.jayklef.mapxenses.model.User;
import com.jayklef.mapxenses.repository.ExpenseRepository;
import com.jayklef.mapxenses.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Expense> getExpenseList() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long expenseId) throws ExpenseNotFoundException {

        Optional<Expense> expense = expenseRepository.findById(expenseId);

        if (expenseId == null){
            throw new ExpenseNotFoundException("Expense not found");
        }

        return expenseRepository.findById(expenseId).get();
    }

    @Override
    public Expense updateExpense(Long expenseId, Expense expense) {
        Expense expenseInDb = expenseRepository.findById(expenseId).get();

        if (Objects.nonNull(expense.getDescription())&&
        !"".equalsIgnoreCase(expense.getDescription())){
            expenseInDb.setDescription(expense.getDescription());
        }

        if (Objects.nonNull(expense.getExpenseDate())&&
                !"".equalsIgnoreCase(expense.getExpenseDate().toString())){
            expenseInDb.setExpenseDate(expense.getExpenseDate());
        }

        if (Objects.nonNull(expense.getAmount())&&
               !"".equalsIgnoreCase(expense.getAmount().toString())){
            expenseInDb.setAmount(expense.getAmount());
        }

        if (Objects.nonNull(expense.getCategory())&&
                !"".equalsIgnoreCase(expense.getCategory().getId().toString())){
            expenseInDb.setCategory(expense.getCategory());
        }

        if (Objects.nonNull(expense.getUser())&&
                !"".equalsIgnoreCase(expense.getUser().getId().toString())){
            expenseInDb.setUser(expense.getUser());
        }
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
      expenseRepository.deleteById(expenseId);
    }
}
