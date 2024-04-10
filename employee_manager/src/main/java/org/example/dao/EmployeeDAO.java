package org.example.dao;

import org.example.model.Employee;
import org.example.model.RoleEmp;
import org.example.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    Connection con;
    private PreparedStatement ps;

    public List<Employee> getAllEmployees(){
        List<Employee> contacts = new ArrayList<>();
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM `contact`");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setRole(RoleEmp.valueOf(rs.getString("role_emp")));
                contacts.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}
