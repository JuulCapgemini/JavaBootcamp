package com.capgemini.javabootcamp.airplane.airplane.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airplane {
    @Id
    @GeneratedValue
    private Long idAirplane;
    private double fuel;
    private double maxFuel;

    public Airplane() {

    }

    public Long getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(Long idAirplane) {
        this.idAirplane = idAirplane;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(double maxFuel) {
        this.maxFuel = maxFuel;
    }
}
