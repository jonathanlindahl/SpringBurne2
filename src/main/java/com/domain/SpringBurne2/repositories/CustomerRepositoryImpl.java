package com.domain.SpringBurne2.repositories;

import com.domain.SpringBurne2.database.Connector;
import com.domain.SpringBurne2.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl
{
    public CustomerRepositoryImpl() {}

    private static Customer makeCustomer(ResultSet rs) throws SQLException
    {
        return new Customer(
                rs.getLong("CustomerID"),
                rs.getString("FirstName"),
                rs.getString("LastName"),
                Customer.Gender.valueOf(rs.getString("Gender")),
                rs.getString("Email"),
                rs.getString("Password"));
    }

    public static List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM customer");
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet != null && resultSet.next())
                customers.add(makeCustomer(resultSet));
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return customers;
    }

    public static Customer addCustomer(Customer c)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO customer VALUES (%d, '%s', '%s', '%s', '%s', '%s')",
                    c.getCustomerId(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getGender().name(),
                    c.getEmail(),
                    c.getPassword());
            statement.executeUpdate(sql);
            System.out.println("Added: " + c.toString());

        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
        }
        return c;
    }

    public static Customer updateCustomer(Long id, Customer newCustomer)
    {
        Connection connection = null;
        Statement statement = null;
        Customer c = getByID(id);
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "UPDATE customer " +
                            "SET FirstName = '%s', " +
                            "LastName = '%s', " +
                            "Email = '%s', " +
                            "Password = '%s' " +
                            "WHERE CustomerID = %d",
                    newCustomer.getFirstName(),
                    newCustomer.getLastName(),
                    newCustomer.getEmail(),
                    newCustomer.getPassword(),
                    c.getCustomerId());
            statement.executeUpdate(sql);
            System.out.println(
                    "Updated: " + c.toString() + "\nNew entry: " + newCustomer.toString());
        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
        }
        return c;
    }

    public static Customer getByID(Long id)
    {
        Customer c = null;
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        String.format(
                                "SELECT * FROM customer WHERE CustomerID = %d",
                                id));
                ResultSet resultSet = statement.executeQuery()
        ) {
            if (resultSet.next())
                c = makeCustomer(resultSet);
        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
            sqlEx.printStackTrace();
        }
        return c;
    }

    public static Customer getByEmail(String email)
    {
        Customer c = null;
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        String.format(
                                "SELECT * FROM customer WHERE Email = '%s'",
                                email));
                ResultSet resultSet = statement.executeQuery()
        ) {
            if (resultSet.next())
                c = makeCustomer(resultSet);
        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
        }
        return c;
    }

    public static Customer deleteCustomer(Long id)
    {
        Connection connection = null;
        Statement statement = null;
        Customer c = getByID(id);
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "DELETE FROM customer WHERE CustomerID = %d",
                    c.getCustomerId());
            statement.executeUpdate(sql);
            System.out.println("Deleted: " + c.toString());

        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
        }
        return c;
    }
}
