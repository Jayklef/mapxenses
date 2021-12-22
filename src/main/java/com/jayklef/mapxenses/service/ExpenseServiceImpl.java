package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.ExpenseNotFoundException;
import com.jayklef.mapxenses.model.Expense;
import com.jayklef.mapxenses.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpenseList() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long id) throws ExpenseNotFoundException {

        Optional<Expense> expense = expenseRepository.findById(id);

        if (id == null){
            throw new ExpenseNotFoundException("Expense not found");
        }

        return expenseRepository.findById(id).get();
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Expense expenseInDb = expenseRepository.findById(id).get();

        if (Objects.nonNull(expense.getDescription())&&
        !"".equalsIgnoreCase(expense.getDescription())){
            expenseInDb.setDescription(expense.getDescription());
        }

        if (Objects.nonNull(expense.getExpenseDate())&&
                !"".equalsIgnoreCase(expense.getExpenseDate().toString())){
            expenseInDb.setExpenseDate(expense.getExpenseDate());
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
    public void deleteExpense(Long id) {
      expenseRepository.deleteById(id);
    }
}
