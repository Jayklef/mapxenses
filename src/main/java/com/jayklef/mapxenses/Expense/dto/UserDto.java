package com.jayklef.mapxenses.Expense.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;
    private String username;
    private String password;
    private String email;
    private String gender;
    private String address;
    private String profession;
}
