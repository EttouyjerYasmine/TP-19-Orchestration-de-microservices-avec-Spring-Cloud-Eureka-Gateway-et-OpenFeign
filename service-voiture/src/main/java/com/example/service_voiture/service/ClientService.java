package com.example.service_voiture.service;

import com.example.service_voiture.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")   // Le nom REGISTRE EUREKA
public interface ClientService {

    @GetMapping("/client/{id}")         // Endpoint du MS Client
    Client clientById(@PathVariable("id") Long id);
}
