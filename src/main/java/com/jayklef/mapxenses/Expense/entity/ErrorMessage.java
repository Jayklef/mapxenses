package com.jayklef.mapxenses.Expense.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private String message;
    private Instant timestamp;
    private String path;
    private HttpStatus status;
}
