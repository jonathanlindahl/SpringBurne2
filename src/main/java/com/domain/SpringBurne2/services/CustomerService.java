package com.domain.SpringBurne2.services;

import com.domain.SpringBurne2.models.Customer;
import com.domain.SpringBurne2.repositories.CustomerRepositoryImpl;

import java.util.List;

public class CustomerService
{
    public List<Customer> getCustomers()
    {
        return CustomerRepositoryImpl.getAllCustomers();
    }
    
    public Customer getById(Long id)
    {
        return CustomerRepositoryImpl.getByID(id);
    }
    
    public Customer getByEmail(String email)
    {
        return CustomerRepositoryImpl.getByEmail(email);
    }
}
