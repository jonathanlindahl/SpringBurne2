package com.domain.SpringBurne2.models;

import com.domain.SpringBurne2.repositories.CustomerRepositoryImpl;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable
{
    public enum Gender {M, F, O}

    private Long customerId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String password;

    public Customer() {}

    public Customer(Long customerId,
                    String firstName,
                    String lastName,
                    Gender gender,
                    String email,
                    String password) {
        this.customerId =
                (customerId == 0L) ? CustomerRepositoryImpl.getAllCustomers().size() + 1 : customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public Long getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Gender getGender() { return gender; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer customer = (Customer) obj;
        return Objects.equals(getCustomerId(), customer.getCustomerId());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
