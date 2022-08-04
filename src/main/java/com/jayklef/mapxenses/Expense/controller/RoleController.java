package com.jayklef.mapxenses.Expense.controller;

import com.jayklef.mapxenses.Expense.dto.RoleDto;
import com.jayklef.mapxenses.Expense.entity.Role;
import com.jayklef.mapxenses.Expense.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody RoleDto roleDto){
        Role newRole = roleService.saveRole(roleDto);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }
}
