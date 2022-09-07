package com.jayklef.mapxenses;

import com.jayklef.mapxenses.Expense.dto.CategoryDto;
import com.jayklef.mapxenses.Expense.dto.ExpenseDto;
import com.jayklef.mapxenses.Expense.entity.Expense;
import com.jayklef.mapxenses.Expense.repository.ExpenseRepository;
import com.jayklef.mapxenses.Expense.service.CategoryService;
import com.jayklef.mapxenses.Expense.service.ExpenseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MapxensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapxensesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(CategoryService categoryService, ExpenseService expenseService){
        return args -> {

            categoryService.saveCategory(new CategoryDto("Healthcare"));
            categoryService.saveCategory(new CategoryDto("Foodstuff"));
            categoryService.saveCategory(new CategoryDto("Beverages"));
            categoryService.saveCategory(new CategoryDto("Electronics"));

           /* categoryService.addExpenseToCategory("Healthcare", "drugs");
            categoryService.addExpenseToCategory("Foodstuff", "rice");
            categoryService.addExpenseToCategory("Foodstuff", "garri");
            categoryService.addExpenseToCategory("Foodstuff", "Beans");
            categoryService.addExpenseToCategory("Healthcare", "vitamin C");
            categoryService.addExpenseToCategory("Foodstuff", "Yam");
            categoryService.addExpenseToCategory("Beverages", "Bournvita");
            categoryService.addExpenseToCategory("Foodstuff", "Indomie"); */
        };
    }
}
