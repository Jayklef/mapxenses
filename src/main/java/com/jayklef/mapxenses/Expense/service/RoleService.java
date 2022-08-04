package com.jayklef.mapxenses.Expense.service;

import com.jayklef.mapxenses.Expense.dto.RoleDto;
import com.jayklef.mapxenses.Expense.entity.Role;

public interface RoleService {
    Role saveRole(RoleDto roleDto);
    Role findByRoleName(String name);
}
