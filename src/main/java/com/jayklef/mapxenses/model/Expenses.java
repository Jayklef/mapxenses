package com.jayklef.mapxenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {

    @Id
    private Long id;
    private Instant expenseDate;
    private String description;
}
