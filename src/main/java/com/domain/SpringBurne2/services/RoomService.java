package com.domain.SpringBurne2.services;

import com.domain.SpringBurne2.models.Room;


import java.util.List;

public class RoomService {


    public List<Room> sortRoomsByPriceDescending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (room1.getRange() == Room.priceRange.HIGH && room2.getRange() == Room.priceRange.MID) {
                return -1;
            }
            else if (room1.getRange() == Room.priceRange.HIGH && room2.getRange() == Room.priceRange.LOW){
                return -1;
            }
            else if (room1.getRange() == Room.priceRange.MID && room2.getRange() == Room.priceRange.LOW){
                return -1;
            }
            else {
                return room1.getName().compareToIgnoreCase(room2.getName());
            }

        });
        return rooms;
    }

    public List<Room> sortRoomsByPriceAscending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (room1.getRange() == Room.priceRange.MID && room2.getRange() == Room.priceRange.HIGH) {
                return -1;
            }
            else if (room1.getRange() == Room.priceRange.LOW && room2.getRange() == Room.priceRange.HIGH){
                return -1;
            }
            else if (room1.getRange() == Room.priceRange.LOW && room2.getRange() == Room.priceRange.MID){
                return -1;
            }
            else  {
                return room1.getName().compareToIgnoreCase(room2.getName());
            }

        });
        return rooms;
    }
    public List<Room> sortRoomsByRatingDescending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (room1.getRating() != room2.getRating()){
                return Integer.compare(room2.getRating(), room1.getRating());
            }
            else{
                return room1.getName().compareToIgnoreCase(room2.getName());
            }

        });
        return rooms;
    }
    public List<Room> sortRoomsByRatingAscending(List<Room> rooms)
    {
        rooms.sort((room1, room2) -> {
            if (room1.getRating() != room2.getRating()){
                return Integer.compare(room1.getRating(), room2.getRating());
            }
            else{
                return room1.getName().compareToIgnoreCase(room2.getName());
            }

        });
        return rooms;
    }

    public List<Room> filterRoomsByPool(List<Room> rooms){
        rooms.removeIf(r -> !r.hasPool());

        return rooms;
    }

    public List<Room> filterRoomsByRestaurant(List<Room> rooms){
        rooms.removeIf(r -> !r.hasRestaurant());

        return rooms;
    }

    public List<Room> filterRoomsByChildClub(List<Room> rooms){
        rooms.removeIf(r -> !r.hasChildClub());

        return rooms;
    }

    public List<Room> filterRoomsBySeaView(List<Room> rooms){
        rooms.removeIf(r -> !r.hasSeaView());

        return rooms;
    }

    public List<Room> filterRoomsByCentralLocation(List<Room> rooms){
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