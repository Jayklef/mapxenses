package com.jayklef.mapxenses.service;

import com.jayklef.mapxenses.exception.UserNotFoundException;
import com.jayklef.mapxenses.model.User;
import com.jayklef.mapxenses.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (id == null){
            throw new UserNotFoundException("User not found");
        }

        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User updateUser(Long id, User user) {

        User userInDb = userRepository.findById(id).get();

        if (Objects.nonNull(user.getName())&&
        !"".equalsIgnoreCase(user.getName())){
            userInDb.setName(user.getName());
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
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}