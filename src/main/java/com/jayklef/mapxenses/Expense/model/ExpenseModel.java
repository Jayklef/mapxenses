package com.jayklef.mapxenses.Expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseModel {

    private String name;
    private String description;
    private LocalDate expenseDate;
    private Double amount;
}
