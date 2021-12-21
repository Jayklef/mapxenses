package com.jayklef.mapxenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ManyToOne
    private Category category;

    @ManyToOne
    private  User user;
}
