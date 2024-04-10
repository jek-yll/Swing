package org.example.dao;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.RoleEmp;
import org.example.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IBaseDAO<Employee> {

    Connection con;
    private PreparedStatement ps;

    @Override
    public List<Employee> getAll(){
        List<Employee> employees = new ArrayList<>();
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM `employee`");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setRole(RoleEmp.valueOf(rs.getString("role_emp")));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public int add(Employee employee) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("INSERT INTO `employee`(`firstname`,`lastname`,`department_id`,`role_emp`) values(?,?,?,?) ");
            ps.setString(1, employee.getFirstname());
            ps.setString(2, employee.getLastname());
            ps.setInt(3, employee.getDepartment().getId());
            ps.setString(4, String.valueOf(employee.getRole()));

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("DELETE FROM `employee` WHERE `id` = ?");
            ps.setInt(1, id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Employee employeeUpdated) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("UPDATE `employee` SET `firstname`=?,`lastname`=?   WHERE `id` = ?");
            ps.setString(1, employeeUpdated.getFirstname());
            ps.setString(2, employeeUpdated.getLastname());
            ps.setInt(3, employeeUpdated.getId());

            return ps.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getById(int id) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM `employee` WHERE `id` = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setRole(RoleEmp.valueOf(rs.getString("role_emp")));
                employee.setDepartment(
                        new Department()
                );
                return employee;
            } else {
                return null;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
