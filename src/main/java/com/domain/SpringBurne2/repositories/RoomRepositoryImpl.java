package com.domain.SpringBurne2.repositories;

import com.domain.SpringBurne2.database.Connector;
import com.domain.SpringBurne2.models.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl
{
    public RoomRepositoryImpl() {}

    private static Room makeRoom(ResultSet rs) throws SQLException
    {
        return new Room(
                rs.getLong("RoomID"),
                rs.getString("Name"),
                rs.getInt("Rating"),
                Room.priceRange.valueOf(rs.getString("PriceRange")),
                rs.getString("City"),
                rs.getString("Description"),
                rs.getInt("Beds"),
                (rs.getInt("Pool") > 0),
                (rs.getInt("Restaurant") > 0),
                (rs.getInt("ChildClub") > 0),
                (rs.getInt("CentralLocation") > 0),
                (rs.getInt("SeaView") > 0));
    }

    public static List<Room> getAllRooms()
    {
        List<Room> rooms = new ArrayList<>();
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM room");
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet != null && resultSet.next())
                rooms.add(makeRoom(resultSet));
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return rooms;
    }

    public static Room getByID(Long id)
    {
        Room r = null;
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        String.format(
                                "SELECT * FROM room WHERE RoomID = %d",
                                id));
                ResultSet resultSet = statement.executeQuery()
        ) {
            if (resultSet.next())
                r = makeRoom(resultSet);
        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
            sqlEx.printStackTrace();
        }
        return r;
    }

    public static Room addRoom(Room r)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO room " +
                            "VALUES (" +
                            "%d, '%s', %d, '%s', '%s', '%s', %d, %d, %d, %d, %d, %d)",
                    r.getRoomId(),
                    r.getName(),
                    r.getRating(),
                    r.getRange().name(),
                    r.getCity(),
                    r.getDescription(),
                    r.getBeds(),
                    // Casting bools to int since mysql's bools are tinyint(1).
                    r.hasPool() ? 1 : 0,
                    r.hasRestaurant() ? 1 : 0,
                    r.hasChildClub() ? 1 : 0,
                    r.hasCentralLocation() ? 1 : 0,
                    r.hasSeaView() ? 1 : 0);
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

    public static Room updateRoom(Long id, Room newRoom)
    {
        Connection connection = null;
        Statement statement = null;
        Room r = getByID(id);
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "UPDATE room " +
                            "SET Name = '%s', " +
                            "Rating = %d, " +
                            "PriceRange = '%s', " +
                            "Description = '%s', " +
                            "Beds = %d " +
                            "WHERE RoomID = %d",
                    newRoom.getName(),
                    newRoom.getRating(),
                    newRoom.getRange().name(),
                    newRoom.getDescription(),
                    newRoom.getBeds(),
                    r.getRoomId());
            statement.executeUpdate(sql);
            System.out.println(
                    "Updated: " + r.toString() + "\nNew entry: " + newRoom.toString());
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

    public static Room deleteRoom(Long id)
    {
        Connection connection = null;
        Statement statement = null;
        Room r = getByID(id);
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "DELETE FROM room WHERE RoomID = %d",
                    r.getRoomId());
            statement.executeUpdate(sql);
            System.out.println("Deleted: " + r.toString());
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
}
