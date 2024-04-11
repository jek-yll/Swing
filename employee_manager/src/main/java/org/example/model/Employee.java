package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dao.DepartmentDAO;
import org.example.dao.EmployeeDAO;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private RoleEmp role;
    private Department department;

    public Employee(String firstname, String lastname, RoleEmp role, Department department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.department = department;
    }
}
