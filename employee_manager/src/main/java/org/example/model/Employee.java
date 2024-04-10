package org.example.model;


import lombok.Data;


@Data
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private RoleEmp role;
    private Department department;

}
