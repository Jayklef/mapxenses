package com.jayklef.mapxenses.repository;

import com.jayklef.mapxenses.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String name);
}