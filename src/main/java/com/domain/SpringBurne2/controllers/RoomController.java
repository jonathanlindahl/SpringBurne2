package com.domain.SpringBurne2.controllers;

import com.domain.SpringBurne2.models.Room;
import com.domain.SpringBurne2.repositories.RoomRepositoryImpl;
import com.domain.SpringBurne2.services.RoomService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class RoomController
{
    RoomService service = new RoomService();
    
    public RoomController() {}

    @GetMapping("/allrooms")
    public List<Room> getRooms() throws ParseException
    {
        return service.getRooms();
    }

    @GetMapping("/getroombyid")
    public Room getById(@RequestParam Long id)
    {
        return RoomRepositoryImpl.getByID(id);
    }

    @PostMapping("/addroom")
    public Room addRoom(@RequestBody Room newRoom)
    {
        return RoomRepositoryImpl.addRoom(newRoom);
    }

    //TODO: set defaults for values that can't change through this method.
    @PutMapping("/updateroom")
    public Room updateRoom(@RequestParam Long id, @RequestBody Room newRoom)
    {
        return RoomRepositoryImpl.updateRoom(id, newRoom);
    }

    @DeleteMapping("/deleteroom")
    public Room deleteRoom(@RequestParam Long id)
    {
        return RoomRepositoryImpl.deleteRoom(id);
    }
}