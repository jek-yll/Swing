package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "bloodGroupBdd";
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "admin";
            return DriverManager.getConnection(url + database , username , password);

    }

}
