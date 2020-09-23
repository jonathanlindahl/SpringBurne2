package com.domain.SpringBurne2.gui.utility;

import com.domain.SpringBurne2.models.Customer;

import com.google.gson.Gson;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class REST
{
    // TODO: ask how to return the object instead of a String representation.
    public Customer getCustomerByEmail(String email)
    {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(String.format(
                            "http://localhost:8080/getcustomerbyemail?email=%s",
                            email)))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        CompletableFuture<HttpResponse<String>> response =
                HttpClient.newBuilder()
                        .build()
                        .sendAsync(
                                request, HttpResponse.BodyHandlers.ofString());
        Customer c = parseCustomer(response.thenApply(HttpResponse::body).join());
        return c;
    }
    
    private Customer parseCustomer(String s)
    {
        String toRemove[] =
                { "customerId", "firstName", "lastName", "gender", "email", "password" };
        String customer = s.replaceAll("[{\":}]", "");
        String custParams[] = customer.split(",");
        for (int i = 0; i < toRemove.length; ++i)
            if (custParams[i].contains(toRemove[i]))
                custParams[i] = custParams[i].replace(toRemove[i], "");
        return new Customer(
                Long.parseLong(custParams[0]),
                custParams[1],
                custParams[2],
                Customer.Gender.valueOf(custParams[3]),
                custParams[4],
                custParams[5]);
    }
    
    public String postUser(Customer c)
    {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/addcustomer"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(c)))
                    .build();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        var response = HttpClient.newBuilder().build().sendAsync(request, HttpResponse.BodyHandlers.ofString());
        return response.thenApply(HttpResponse::body).join();
    }
    
//    public Room getRooms()
//    {
//        HttpRequest request = null;
//        try {
//            request = HttpRequest.newBuilder()
//                    .uri(new URI("http://localhost:8080/allrooms"))
//                    .GET()
//                    .build();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        CompletableFuture<HttpResponse<String>> response =
//                HttpClient.newBuilder()
//                        .build()
//                        .sendAsync(
//                                request, HttpResponse.BodyHandlers.ofString());
//        Room r = parseRoom(response.thenApply(HttpResponse::body).join());
//        return r;
//    }
//
//    private Customer parseRoom(String s)
//    {
//        String toRemove[] =
//                { "roomId", "name", "lastName", "gender", "email", "password" };
//        String customer = s.replaceAll("[{\":}]", "");
//        String custParams[] = customer.split(",");
//        for (int i = 0; i < toRemove.length; ++i)
//            if (custParams[i].contains(toRemove[i]))
//                custParams[i] = custParams[i].replace(toRemove[i], "");
//        return new Room(
//                Long.parseLong(custParams[0]),
//                custParams[1],
//                custParams[2],
//                Customer.Gender.valueOf(custParams[3]),
//                custParams[4],
//                custParams[5]);
//    }
}
