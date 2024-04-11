package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.RoleEmp;

public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(){
        employeeDAO = new EmployeeDAO();
    }

    public Boolean addEmployee(String firstname, String lastname, RoleEmp role, Department department){
        Employee employee = Employee.builder()
                .firstname(firstname)
                .lastname(lastname)
                .role(role)
                .department(department)
                .build();
        return employeeDAO.add(employee) > 0;
    }
}
