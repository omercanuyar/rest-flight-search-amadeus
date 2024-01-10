package com.amadeus.restflightsearchamadeus.service;

import com.amadeus.restflightsearchamadeus.model.Airport;
import com.amadeus.restflightsearchamadeus.model.Flight;

import java.util.List;

public interface FlightService {
    public String createFlight(Flight flight);
    public String updateFlight(Flight flight);
    public String deleteFlight(String id);
    public Flight getFlight(String id);
    public List<Flight> getAllFlight();
}
