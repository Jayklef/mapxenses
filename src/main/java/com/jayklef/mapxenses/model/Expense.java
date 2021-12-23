package com.jayklef.mapxenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    private Long id;
    private String description;
    private LocalDate expenseDate;
    private BigDecimal amount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private  User user;
}
