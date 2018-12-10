package com.capgemini.javabootcamp.airplane.airplane.repository;

import com.capgemini.javabootcamp.airplane.airplane.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane,Long> {
}
