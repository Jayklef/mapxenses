package com.jayklef.mapxenses.Expense.repository;

import com.jayklef.mapxenses.Expense.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String name);
}
