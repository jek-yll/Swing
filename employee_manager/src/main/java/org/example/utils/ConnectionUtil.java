package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "employee_manager_bdd";
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "admin";
            return DriverManager.getConnection(url + database , username , password);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
