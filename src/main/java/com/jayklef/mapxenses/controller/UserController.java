package com.jayklef.mapxenses.controller;

import com.jayklef.mapxenses.exception.UserNotFoundException;
import com.jayklef.mapxenses.model.User;
import com.jayklef.mapxenses.service.ExpenseService;
import com.jayklef.mapxenses.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> getUserList(){
        log.info("Inside getUserList of UserController");
        return userService.getUserList();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        log.info("Inside getUserById of UserController");
        return userService.getUserById(id);
    }

    @GetMapping("/users/name")
    public User getUserByName(@PathVariable("name") String name){
        log.info("Inside getUserByName of UserController");
        return userService.getUserByName(name);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id,
                           @RequestBody User user){
        log.info("Inside updateUser of UserController");
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
