package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.dto.ExpenseDto;
import com.jayklef.mapxenses.Expense.repository.ExpenseRepository;
import com.jayklef.mapxenses.Expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Expense> findExpenseList() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setDescription(expenseDto.getDescription());
        expense.setAmount(expenseDto.getAmount());
        expense.setExpenseDate(expenseDto.getExpenseDate());

        return expenseRepository.save(expense);
    }

    @Override
    public Expense findExpenseById(Long expenseId) throws ExpenseNotFoundException {

        Optional<Expense> expense = expenseRepository.findById(expenseId);

        if (expense.isEmpty()){
            throw new ExpenseNotFoundException("Expense not found");
        }

        return expenseRepository.findById(expenseId).get();
    }

    @Override
    public Double calculateWeeklyExpenses(LocalDate startDate, LocalDate endDate) {
        List<Expense> expenses = expenseRepository.findByExpensesBetween(startDate, endDate);

        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    @Override
    public Double calculateMonthlyExpenses(LocalDate startDate, LocalDate endDate) {

        List<Expense> monthlyExpenses = expenseRepository.findAllExpensesBetween(startDate, endDate);

       // LocalDate start = LocalDate.parse("2020-11-03");
       // LocalDate end = LocalDate.parse("2020-12-15");

     //   Double diff = Double.valueOf(DAYS.between(start, end));

        return monthlyExpenses.stream()
                 .mapToDouble(Expense::getAmount)
                .sum();

    }

    @Override
    public Expense findByName(String name) {
        return expenseRepository.findByName(name);
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
