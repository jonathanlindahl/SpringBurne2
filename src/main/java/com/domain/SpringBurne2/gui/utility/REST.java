package com.domain.SpringBurne2.gui.utility;

import com.domain.SpringBurne2.models.Customer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    
    public Customer parseCustomer(String s)
    {
        String toRemove[] =
                { "customerId", "firstName", "lastName", "gender", "email", "password" };
        char sArr[] = s.toCharArray();
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
}
