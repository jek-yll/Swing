package org.example.dao;

import org.example.model.Department;
import org.example.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements IBaseDAO<Department> {

    Connection con;
    private PreparedStatement ps;

    @Override
    public int add(Department department)  {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("INSERT INTO `department`(`name`) values(?) ");
            ps.setString(1, department.getName());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int delete(int id) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("DELETE FROM `department` WHERE `id` = ?");
            ps.setInt(1, id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public int update (Department departmentUpdated){
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("UPDATE `department` SET `name` = ?  WHERE `id` = ?");
            ps.setString(1, departmentUpdated.getName());
            ps.setInt(1, departmentUpdated.getId());

            return ps.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Department> getAll (){
        List<Department> departments = new ArrayList<>();
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM `department`");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }
    @Override
    public Department getById(int id){
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM `department` WHERE `id` = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                return department;
            } else {
                return null;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
