package com.capgemini.javabootcamp.airplane.airplane.controller;

import com.capgemini.javabootcamp.airplane.airplane.model.Airplane;
import com.capgemini.javabootcamp.airplane.airplane.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/airplane")
public class AirplaneController {

    @Autowired
    private final AirplaneRepository airplaneRepository;

    public AirplaneController(AirplaneRepository repository) {
        airplaneRepository = repository;
    }

    @GetMapping("/all")
    List<Airplane> all() {
        return airplaneRepository.findAll();
    }

    @PostMapping("/add")
    public Airplane addAirplane(@RequestBody Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

}

