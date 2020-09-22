package com.domain.SpringBurne2.controllers;

import com.domain.SpringBurne2.models.Reservation;
import com.domain.SpringBurne2.repositories.ReservationRepositoryImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ReservationController
{
    @GetMapping("/allreservations")
    public List<Reservation> getReservations()
    {
        return ReservationRepositoryImpl.getAllReservations();
    }

    @GetMapping("/getreservationbyid")
    public Reservation getById(@RequestParam Long id)
    {
        return ReservationRepositoryImpl.getById(id);
    }

    @PostMapping("/addreservation")
    public Reservation addReservation(@RequestBody Reservation newReservation)
    {
        return ReservationRepositoryImpl.addReservation(newReservation);
    }

    @PutMapping("/updatereservation")
    public Reservation updateReservation(
            @RequestParam Long id, @RequestBody Reservation newReservation)
    {
        return ReservationRepositoryImpl.updateReservation(id, newReservation);
    }

    @DeleteMapping("/deletereservation")
    public Reservation deleteReservation(@RequestParam Long id)
    {
        return ReservationRepositoryImpl.deleteReservation(id);
    }
}