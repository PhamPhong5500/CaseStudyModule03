package com.codegym.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String CONN_URL= "jdbc:mysql://localhost:3306/caseStudy03";
    private static String USER_NAME = "root";
    private static String PASSWORD = "miumap432";
    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for jdbc connection!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not find database!");
            e.printStackTrace();
        }
        return null;
    }
}