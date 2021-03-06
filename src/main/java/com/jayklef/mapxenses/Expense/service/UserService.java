package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.exception.UserNotFoundException;
import com.jayklef.mapxenses.Expense.model.User;

import java.util.List;

public interface UserService {
    List<User> findUserList();

    User saveUser(User user);

    User findUserById(Long id) throws UserNotFoundException;

    User findUserByName(String name);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

}
