package com.capgemini.javabootcamp.airplane.airplane.controller;

import com.capgemini.javabootcamp.airplane.airplane.model.Airport;
import com.capgemini.javabootcamp.airplane.airplane.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AirportController {
    @Autowired
    private final AirportRepository airportRepository;

    public AirportController(AirportRepository repository) {
        airportRepository = repository;
    }

    @GetMapping("/all")
    List<Airport> all() {
        return airportRepository.findAll();
    }

    @PostMapping("/add")
    public Airport addAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

}
