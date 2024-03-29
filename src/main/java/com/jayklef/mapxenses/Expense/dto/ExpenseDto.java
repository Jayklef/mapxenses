package com.jayklef.mapxenses.Expense.dto;

import com.jayklef.mapxenses.Expense.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    private String name;
    private String description;
    private LocalDate expenseDate;
    private Double amount;
    private Long categoryId;
}
