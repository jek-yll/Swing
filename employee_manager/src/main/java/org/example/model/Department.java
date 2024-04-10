package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Department {

    private int id;
    private String name;
    private List<Employee> employees;

}
