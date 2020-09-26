package com.domain.SpringBurne2.repositories;

import com.domain.SpringBurne2.database.Connector;
import com.domain.SpringBurne2.models.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationRepositoryImpl
{
    public ReservationRepositoryImpl() {}

    public static Reservation makeReservation(ResultSet rs) throws SQLException
    {
        return new Reservation(
                rs.getLong("BookingID"),
                rs.getLong("CustomerID"),
                rs.getLong("RoomID"),
                rs.getString("StartDate"),
                rs.getString("EndDate"),
                rs.getBoolean("HalfBoard"),
                rs.getBoolean("FullBoard"),
                rs.getBoolean("AllInclusive"),
                rs.getInt("ExtraBeds"),
                rs.getInt("ExtraCribs"),
                rs.getInt("Aults"),
                rs.getInt("Kids"));
    }

    public static List<Reservation> getAllReservations()
    {
        List<Reservation> reservations = new ArrayList<>();
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM booking");
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet != null && resultSet.next())
                reservations.add(makeReservation(resultSet));
        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
        }
        return reservations;
    }

    public static Reservation getById(Long id)
    {
        Reservation r = null;
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        String.format(
                                "SELECT * FROM booking WHERE BookingID = %d",
                                id));
                ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next())
                r = makeReservation(resultSet);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            System.out.println("SQLException: " + sqlEx.getMessage());
        }
        return r;
    }

    public static Reservation addReservation(Reservation r)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO booking VALUES (%d, %d, %d, '%s', '%s')",
                    r.getReservationId(),
                    r.getCustomerId(),
                    r.getRoomId(),
                    r.getStartDate(),
                    r.getEndDate());
            statement.executeUpdate(sql);
            System.out.println("Added: " + r.toString());
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
        return r;
    }

    public static Reservation updateReservation(Long id, Reservation newReservation)
    {
        Connection connection = null;
        Statement statement = null;
        Reservation r = getById(id);
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "UPDATE booking " +
                            "SET RoomID = %d, " +
                            "StartDate = '%s', " +
                            "EndDate = '%s' " +
                            "WHERE BookingID = %d",
                    newReservation.getRoomId(),
                    newReservation.getStartDate(),
                    newReservation.getEndDate(),
                    r.getReservationId());
            statement.executeUpdate(sql);
            System.out.println(
                    "Updated: " + r.toString() + "\nNew entry: " + newReservation.toString());
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
        return r;
    }

    public static Reservation deleteReservation(Long id)
    {
        Connection connection = null;
        Statement statement = null;
        Reservation r = getById(id);
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "DELETE FROM booking WHERE BookingID = %d",
                    r.getReservationId());
            statement.executeUpdate(sql);
            System.out.println("Deleted: " + r.toString());
        } catch (SQLException sqlEx) {
            System.out.println("SQLException" + sqlEx.getMessage());
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
        return r;
    }

    private static String formatDate(Date javaDate)
    {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(javaDate);
    }
}
