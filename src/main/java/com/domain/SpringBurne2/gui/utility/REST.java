package com.domain.SpringBurne2.gui.utility;

import com.domain.SpringBurne2.models.Customer;

import com.domain.SpringBurne2.models.Room;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class REST
{
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
        String json = response.thenApply(HttpResponse::body).join();
        Type type = new TypeToken<Customer>(){}.getType();
        return new Gson().fromJson(json, type);
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
        var response =
                HttpClient.newBuilder().build().sendAsync(
                        request, HttpResponse.BodyHandlers.ofString());
        return response.thenApply(HttpResponse::body).join();
    }
    
    public String updateUser(Customer c)
    {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(
                            String.format("http://localhost:8080/updatecustomer?id=%d",
                                    c.getCustomerId())))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(c)))
                    .build();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        var response =
                HttpClient.newBuilder().build().sendAsync(
                        request, HttpResponse.BodyHandlers.ofString());
        return response.thenApply(HttpResponse::body).join();
    }
    
    // TODO: add Search object parameter
    public List<Room> getRooms()
    {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/allrooms"))
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
        String jsonRooms = response.thenApply(HttpResponse::body).join();
        Type listType = new TypeToken<List<Room>>() {}.getType();
        return new Gson().fromJson(jsonRooms, listType);
    }
}
