package com.amadeus.restflightsearchamadeus.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="flight")
public class Flight {
    public Flight() {
    }
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id")
    private Airport departureAirport;
    @ManyToOne
    @JoinColumn(name= "arrival_airport_id", referencedColumnName = "id")
    private Airport arrivalAirport;
    private Date date;
    private double price;


    public Flight(String id, Airport departureAirport, Airport arrivalAirport, Date date, double price) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.date = date;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date departureDate) {
        this.date = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
