package com.jayklef.mapxenses.controller;

import com.jayklef.mapxenses.model.User;
import com.jayklef.mapxenses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return userService.getUserByName(name);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id,
                           @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
