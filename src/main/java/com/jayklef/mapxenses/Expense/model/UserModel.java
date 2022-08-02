package com.jayklef.mapxenses.Expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String name;
    private String email;
    private String gender;
    private String address;
    private String profession;
}
