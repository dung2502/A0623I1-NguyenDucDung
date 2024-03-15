package com.example.teststudent.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/studentManager?characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "123456";

    private static Connection connection;

    static{
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection(jdbcURL,username,password);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public BaseDao() {
    }
    public static Connection getConnectionJavaToDB() {
        return connection;
    }
}

