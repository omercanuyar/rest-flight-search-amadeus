package com.amadeus.restflightsearchamadeus.service.impl;

import com.amadeus.restflightsearchamadeus.model.Flight;
import com.amadeus.restflightsearchamadeus.repository.FlightRepository;
import com.amadeus.restflightsearchamadeus.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public String createFlight(Flight flight) {
        flightRepository.save(flight);
        return "Success";
    }

    @Override
    public String updateFlight(Flight flight) {
        flightRepository.save(flight);
        return "Success";
    }

    @Override
    public String deleteFlight(String id) {
        flightRepository.deleteById(id);
        return "Success";
    }

    @Override
    public Flight getFlight(String id) {
        return flightRepository.findById(id).get();
    }

    @Override
    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }
}
