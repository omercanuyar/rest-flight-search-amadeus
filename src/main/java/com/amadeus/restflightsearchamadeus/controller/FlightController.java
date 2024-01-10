package com.amadeus.restflightsearchamadeus.controller;

import com.amadeus.restflightsearchamadeus.model.Flight;
import com.amadeus.restflightsearchamadeus.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("{id}")
    public Flight getFlightDetails(@PathVariable("id") String id){
        return flightService.getFlight(id);
    }

    @GetMapping()
    public List<Flight> getAllFlightDetails(){
        return flightService.getAllFlight();
    }

    @PostMapping
    public String createFlightDetails(@RequestBody Flight flight){
        flightService.createFlight(flight);
        return "Flight created successfully.";
    }
    @PutMapping
    public String updateFlightDetails(@RequestBody Flight flight){
        flightService.updateFlight(flight);
        return "Flight updated successfully.";
    }

    @DeleteMapping("{id}")
    public String deleteFlightDetails(String id){
        flightService.deleteFlight(id);
        return "Flight deleted successfully.";
    }
}