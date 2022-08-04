package com.jayklef.mapxenses.Expense.repository;

import com.jayklef.mapxenses.Expense.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT u FROM Role u WHERE u.name IN :names")
    Role findByRoleName(String name);
}
