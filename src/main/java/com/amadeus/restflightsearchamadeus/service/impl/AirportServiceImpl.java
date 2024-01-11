package com.amadeus.restflightsearchamadeus.service.impl;

import com.amadeus.restflightsearchamadeus.exception.AirportNotFoundException;
import com.amadeus.restflightsearchamadeus.model.Airport;
import com.amadeus.restflightsearchamadeus.repository.AirportRepository;
import com.amadeus.restflightsearchamadeus.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirportServiceImpl implements AirportService {
    AirportRepository airportRepository;
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public String createAirport(Airport airport) {
        airportRepository.save(airport);
        return "Success";
    }

    @Override
    public String updateAirport(Airport airport) {
        // More Business Logic Here
        airportRepository.save(airport);
        return "Success";
    }

    @Override
    public String deleteAirport(String id) {
        airportRepository.deleteById(id);
        return "Success";
    }

    @Override
    public Airport getAirport(String id) {
        if(airportRepository.findById(id).isEmpty()){
            throw new AirportNotFoundException("Requested Airport does not exist.");
        }
        return airportRepository.findById(id).get();
    }

    @Override
    public List<Airport> getAllAirport() {
        return airportRepository.findAll();
    }
}
