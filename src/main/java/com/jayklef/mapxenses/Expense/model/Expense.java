package com.jayklef.mapxenses.Expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    private Long expenseId;
    private String description;
    private LocalDate expenseDate;
    private Double amount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private  User user;
}
