package com.amadeus.restflightsearchamadeus.service;

import com.amadeus.restflightsearchamadeus.model.Airport;

import java.util.List;

public interface AirportService {
    public String createAirport(Airport airport);
    public String updateAirport(Airport airport);
    public String deleteAirport(String id);
    public Airport getAirport(String id);
    public List<Airport> getAllAirport();

}
