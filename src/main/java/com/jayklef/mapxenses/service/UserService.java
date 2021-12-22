package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.UserNotFoundException;
import com.jayklef.mapxenses.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User saveUser(User user);

    User getUserById(Long id) throws UserNotFoundException;

    User getUserByName(String name);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
