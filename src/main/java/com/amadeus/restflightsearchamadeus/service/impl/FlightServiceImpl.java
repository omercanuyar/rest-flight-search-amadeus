package com.amadeus.restflightsearchamadeus.service.impl;
import com.amadeus.restflightsearchamadeus.exception.FlightNotFoundException;
import com.amadeus.restflightsearchamadeus.model.Airport;
import com.amadeus.restflightsearchamadeus.model.Flight;
import com.amadeus.restflightsearchamadeus.repository.FlightRepository;
import com.amadeus.restflightsearchamadeus.service.AirportService;
import com.amadeus.restflightsearchamadeus.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;
    AirportService airportService;
    public FlightServiceImpl(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
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
        if(flightRepository.findById(id).isEmpty()){
            throw new FlightNotFoundException("Requested Flight does not exist.");
        }
        return flightRepository.findById(id).get();
    }

    @Override
    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> searchFlights(String departure, String destination, Date date) {

        Airport departureAirport = airportService.getAirportByName(departure);
        Airport destinationAirport = airportService.getAirportByName(destination);

        return flightRepository.findFlightByDepartureAirportAndArrivalAirportAndDate(departureAirport,destinationAirport,date);
    }
}
