package com.jayklef.mapxenses.Expense.utils;

import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


public class Utility {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private RestTemplate restTemplate;

    public Object ExpenseChart(){
        Expense barchart = restTemplate.getForObject("https://code.highcharts.com/highcharts.js",Expense.class);
        return barchart.getClass();
    }
}