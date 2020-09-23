package com.domain.SpringBurne2.services;

import com.domain.SpringBurne2.models.Reservation;
import com.domain.SpringBurne2.models.Room;
import com.domain.SpringBurne2.repositories.ReservationRepositoryImpl;
import com.domain.SpringBurne2.repositories.RoomRepositoryImpl;
import com.domain.SpringBurne2.utility.Search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService
{
    public List<Room> getRooms() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        return filterSearch(
//                RoomRepositoryImpl.getAllRooms(),
//                // TODO: replace with actual search from GUI
//                new Search(
//                        sdf.parse("2020-10-03"),
//                        sdf.parse("2020-10-18"),
//                        0,
//                        0,
//                        false,
//                        false,
//                        false,
//                        false,
//                        false));
        return RoomRepositoryImpl.getAllRooms();
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
    
    public List<Room> availableBetween(List<Room> rooms, Date start, Date end) throws ParseException
    {
        List<Reservation> reservations =
                ReservationRepositoryImpl.getAllReservations();
        for (Reservation reservation : reservations)
        {
            for (Iterator<Room> it = rooms.listIterator(); it.hasNext();)
            {
                Room room = it.next();
                if (
                        reservation.getRoomId().equals(room.getRoomId())
                        && overlap(
                        start,
                        end,
                        new SimpleDateFormat("yyyy-MM-dd")
                                .parse(reservation.getStartDate()),
                        new SimpleDateFormat("yyyy-MM-dd")
                                .parse(reservation.getEndDate())))
                    it.remove();
            }
        }
        return rooms;
    }
    
    public List<Room> filterSearch(List<Room> rooms, Search s) throws ParseException
    {
        return availableBetween(
                rooms, s.getStartDate(), s.getEndDate())
                .stream()
                .filter(r -> r.getDistanceToBeach() < s.getDistanceToBeach())
                .filter(r -> r.getDistanceToCenter() < s.getDistanceToCenter())
                .filter(r -> r.isPool() || !s.getPool())
                .filter(r -> r.isRestaurant() || !s.getRestaurant())
                .filter(r -> r.isChildClub() || !s.getChildClub())
                .filter(r -> r.isCentralLocation() || !s.getCentralLocation())
                .filter(r -> r.isSeaView() || !s.getSeaView())
                .collect(Collectors.toList());
    }
    
    public List<Room> filterRoomsByPool(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.isPool());
        return rooms;
    }
    
    public List<Room> filterRoomsByRestaurant(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.isRestaurant());
        return rooms;
    }
    
    public List<Room> filterRoomsByChildClub(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.isChildClub());
        return rooms;
    }
    
    public List<Room> filterRoomsBySeaView(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.isSeaView());
        return rooms;
    }
    
    public List<Room> filterRoomsByCentralLocation(List<Room> rooms)
    {
        rooms.removeIf(r -> !r.isCentralLocation());
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