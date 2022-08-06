package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.dto.RoleDto;
import com.jayklef.mapxenses.Expense.entity.Role;
import com.jayklef.mapxenses.Expense.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleResult;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role saveRole(RoleDto roleDto) {

        Role role = new Role();
        role.setName(roleDto.getName());
        return roleRepository.save(role);
    }

    @Override
    public Role findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }
}
