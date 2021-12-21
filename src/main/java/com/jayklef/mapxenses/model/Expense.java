package com.jayklef.mapxenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    private Long id;
    private Instant expenseDate;
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private  User user;
}
