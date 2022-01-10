package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.UserNotFoundException;
import com.jayklef.mapxenses.model.Expense;
import com.jayklef.mapxenses.model.User;

import java.util.List;

public interface UserService {
    List<User> findUserList();

    User saveUser(User user);

    User findUserById(Long id) throws UserNotFoundException;

    User findUserByName(String name);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

}
