package com.domain.SpringBurne2.services;

import com.domain.SpringBurne2.models.Reservation;
import com.domain.SpringBurne2.models.Room;
import com.domain.SpringBurne2.repositories.ReservationRepositoryImpl;
import com.domain.SpringBurne2.repositories.RoomRepositoryImpl;
import com.domain.SpringBurne2.utility.Search;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService
{
    public List<Room> getRooms()
    {
        return filterSearch(
                RoomRepositoryImpl.getAllRooms(),
                // TODO: replace with actual search from GUI
                new Search(
                        new Date(),
                        new Date(),
                        0,
                        0,
                        true,
                        false,
                        false,
                        false,
                        false));
    }
    
    public List<Room> sortRoomsByPriceDescending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (
                    room1.getRange() == Room.priceRange.HIGH &&
                            room2.getRange() == Room.priceRange.MID)
                return -1;
            else if (
                    room1.getRange() == Room.priceRange.HIGH &&
                            room2.getRange() == Room.priceRange.LOW)
                return -1;
            else if (
                    room1.getRange() == Room.priceRange.MID &&
                            room2.getRange() == Room.priceRange.LOW)
                return -1;
            else if (
                    room1.getRange().toString().compareTo(
                            room2.getRange().toString()) == 0)
                return room1.getName().compareToIgnoreCase(room2.getName());
            else
                return 1;
        });
        return rooms;
    }
    
    public List<Room> sortRoomsByPriceAscending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (
                    room1.getRange() == Room.priceRange.MID &&
                            room2.getRange() == Room.priceRange.HIGH)
                return -1;
            else if (
                    room1.getRange() == Room.priceRange.LOW &&
                            room2.getRange() == Room.priceRange.HIGH)
                return -1;
            else if (
                    room1.getRange() == Room.priceRange.LOW &&
                            room2.getRange() == Room.priceRange.MID)
                return -1;
            else if (
                    room1.getRange().toString().compareTo(
                            room2.getRange().toString()) == 0)
                return room1.getName().compareToIgnoreCase(room2.getName());
            else
                return 1;
        });
        return rooms;
    }
    
    public List<Room> sortRoomsByRatingDescending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (room1.getRating() != room2.getRating())
                return Integer.compare(room2.getRating(), room1.getRating());
            else
                return room1.getName().compareToIgnoreCase(room2.getName());
        });
        return rooms;
    }
    
    public List<Room> sortRoomsByRatingAscending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (room1.getRating() != room2.getRating())
                return Integer.compare(room1.getRating(), room2.getRating());
            else
                return room1.getName().compareToIgnoreCase(room2.getName());
        });
        return rooms;
    }
    
    private static boolean overlap(
            Date start1, Date end1, Date start2, Date end2)
    {
        return
                start1.getTime() <= end2.getTime() &&
                        start2.getTime() <= end1.getTime();
    }
    
    public List<Room> availableBetween(List<Room> rooms, Date start, Date end)
    {
        List<Reservation> reservations =
                ReservationRepositoryImpl.getAllReservations();
        for (Reservation reservation : reservations)
        {
            rooms.removeIf(
                    room -> overlap(
                            start,
                            end,
                            reservation.getStartDate(),
                            reservation.getEndDate()));
        }
        return rooms;
    }
    
    public List<Room> filterSearch(List<Room> rooms, Search s)
    {
        return availableBetween(
                rooms, s.getStartDate(), s.getEndDate())
                .stream()
                .filter(r -> r.hasPool() || !s.getPool())
                .filter(r -> r.hasRestaurant() || !s.getRestaurant())
                .filter(r -> r.hasChildClub() || !s.getChildClub())
                .filter(r -> r.hasCentralLocation() || !s.getCentralLocation())
                .filter(r -> r.hasSeaView() || !s.getSeaView())
                .collect(Collectors.toList());
    }
    
    public List<Room> filterRoomsByPool(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.hasPool());
        return rooms;
    }
    
    public List<Room> filterRoomsByRestaurant(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.hasRestaurant());
        return rooms;
    }
    
    public List<Room> filterRoomsByChildClub(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.hasChildClub());
        return rooms;
    }
    
    public List<Room> filterRoomsBySeaView(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.hasSeaView());
        return rooms;
    }
    
    public List<Room> filterRoomsByCentralLocation(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.hasCentralLocation());
        return rooms;
    }
    
    //Kom ihåg att ändra r.getRating() till r.getDistanceBeach
    public List<Room> filterRoomsByDistanceBeach(List<Room> rooms, int distance){
        rooms.removeIf(r -> r.getRating() > distance);
        
        return rooms;
    }
    
    //Kom ihåg att ändra r.getRating() till r.getDistanceCenter
    public List<Room> filterRoomsByDistanceCenter(List<Room> rooms, int distance){
        rooms.removeIf(r -> r.getRating() > distance);
        
        return rooms;
    }
}