package com.domain.SpringBurne2.controllers;

import com.domain.SpringBurne2.repositories.CustomerRepositoryImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.domain.SpringBurne2.models.Customer;

import java.util.List;

@RestController
public class CustomerController
{
    public CustomerController() {}

    @GetMapping("/getcustomerbyid")
    public Customer getById(@RequestParam Long id)
    {
        return CustomerRepositoryImpl.getByID(id);
    }

    @GetMapping("/getcustomerbyemail")
    public Customer getByEmail(@RequestParam String email)
    {
        return CustomerRepositoryImpl.getByEmail(email);
    }

    @GetMapping("/allcustomers")
    public List<Customer> getCustomers()
    {
        return CustomerRepositoryImpl.getAllCustomers();
    }

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer newCustomer)
    {
        return CustomerRepositoryImpl.addCustomer(newCustomer);
    }

    //TODO: set defaults for values that can't change through this method.
    @PutMapping("/updatecustomer")
    public Customer updateCustomer(
            @RequestParam Long id, @RequestBody Customer newCustomer)
    {
        return CustomerRepositoryImpl.updateCustomer(id, newCustomer);
    }

    @DeleteMapping("/deletecustomer")
    public Customer deleteCustomer(@RequestParam Long id)
    {
        return CustomerRepositoryImpl.deleteCustomer(id);
    }
}