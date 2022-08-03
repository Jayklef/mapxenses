package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.dto.UserDto;
import com.jayklef.mapxenses.Expense.exception.UserNotFoundException;
import com.jayklef.mapxenses.Expense.entity.User;
import com.jayklef.mapxenses.Expense.repository.ExpenseRepository;
import com.jayklef.mapxenses.Expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<User> findUserList() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = new User();
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setGender(user.getGender());
        userDto.setAddress(user.getAddress());
        userDto.setProfession(user.getProfession());
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException(String.format("User with id %d not found",id ));
        }

        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByName(String name) {
        User user = userRepository.findUserByName(name);

        if (user == null){
            throw new RuntimeException("User not found");
        }
        return userRepository.findUserByName(name);
    }

    @Override
    public User updateUser(Long id, User user) {

        User userInDb = userRepository.findById(id).get();

        if (Objects.nonNull(user.getName())&&
        !"".equalsIgnoreCase(user.getName())){
            userInDb.setName(user.getName());
        }

        if (Objects.nonNull(user.getUsername()) &&
        !"".equalsIgnoreCase(user.getUsername())){
            userInDb.setUsername(user.getUsername());
        }

        if (Objects.nonNull(user.getPassword())&&
        !"".equalsIgnoreCase(user.getPassword())){
            userInDb.setPassword(user.getPassword());
        }

        if (Objects.nonNull(user.getEmail())&&
                !"".equalsIgnoreCase(user.getEmail())){
            userInDb.setEmail(user.getEmail());
        }

        if (Objects.nonNull(user.getGender())&&
                !"".equalsIgnoreCase(user.getGender())){
            userInDb.setGender(user.getGender());
        }

        if (Objects.nonNull(user.getAddress())&&
                !"".equalsIgnoreCase(user.getAddress())){
            userInDb.setAddress(user.getAddress());
        }

        if (Objects.nonNull(user.getProfession())&&
                !"".equalsIgnoreCase(user.getProfession())){
            userInDb.setProfession(user.getProfession());
        }
        return userRepository.save(userInDb);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
