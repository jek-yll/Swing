package org.example.model;

import lombok.*;
import org.example.dao.DepartmentDAO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private int id;
    private String name;
    private List<Employee> employees;

    public int getCountEmployees(){
        DepartmentDAO dao = new DepartmentDAO();
        return dao.getCountEmployeesByDepartment(this);
    }

    @Override
    public String toString() {
        return  "ID : " + id + "     Name : " + name +
                "     Employees Count : " + getCountEmployees() ;
    }
}
