package com.capgemini.javabootcamp.airplane.airplane.model;

import javax.persistence.Id;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Airport {

    @Id @GeneratedValue
    private Long idAirport;

    @OneToMany(
            //mappedBy = "menuItem",
            cascade = CascadeType.REMOVE
            //orphanRemoval = true
    )
    private List<Airplane> airplanes;

    public Airport() {

    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public Long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }
}
