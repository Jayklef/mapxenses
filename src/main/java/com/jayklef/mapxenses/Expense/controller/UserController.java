package com.jayklef.mapxenses.Expense.controller;

import com.jayklef.mapxenses.Expense.exception.UserNotFoundException;
import com.jayklef.mapxenses.Expense.model.User;
import com.jayklef.mapxenses.Expense.service.ExpenseService;
import com.jayklef.mapxenses.Expense.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList(){
        log.info("Inside getUserList of UserController");
        List<User> user = userService.findUserList();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> newUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        log.info("Inside getUserById of UserController");
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/name")
    public ResponseEntity<User> getUserByName(@PathVariable("name") String name){
        log.info("Inside getUserByName of UserController");
        User user = userService.findUserByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                           @RequestBody User user){
        log.info("Inside updateUser of UserController");
        User updateUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        log.info("Inside updateUser of UserController");
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
