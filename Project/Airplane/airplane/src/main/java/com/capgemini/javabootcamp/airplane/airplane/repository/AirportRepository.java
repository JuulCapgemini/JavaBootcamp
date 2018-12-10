package com.capgemini.javabootcamp.airplane.airplane.repository;

import com.capgemini.javabootcamp.airplane.airplane.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
