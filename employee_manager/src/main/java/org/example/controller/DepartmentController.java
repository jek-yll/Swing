package org.example.controller;

import org.example.dao.DepartmentDAO;
import org.example.model.Department;

import java.util.List;

public class DepartmentController {
    private DepartmentDAO departmentDAO;
    public DepartmentController(){
        departmentDAO = new DepartmentDAO();
    }

    public Boolean addDepartment(String name){
        if (departmentDAO.add(Department.builder().name(name).build()) > 0){
            return true;
        } else {
            return false;
        }
    }

    public List<Department> getDepartments(){
        return departmentDAO.getAll();
    }

    public Department getDepartmentByName (String name){
        return departmentDAO.getDepartmentByName(name);
    }
}
