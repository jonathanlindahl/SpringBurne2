package com.domain.SpringBurne2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connector
{
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static Connector connector = new Connector();


    private Connector()
    {
    }

    public static Connector getInstance()
    {
        return connector;
    }

    public static Connection getConnection()
    {
        connect();
        return connection;
    }

    private static void connect()
    {
        statement = null;
        resultSet = null;

        // Find driver
        try {
            Class
                    .forName("com.mysql.cj.jdbc.Driver")
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            System.out.println("Failed to register connector");
            return;
        }

        // Connect to database
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/springburnetest?serverTimezone=UTC",
                    "root",
                    "");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}