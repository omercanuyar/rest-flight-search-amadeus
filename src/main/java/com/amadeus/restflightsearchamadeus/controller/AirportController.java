package com.amadeus.restflightsearchamadeus.controller;

import com.amadeus.restflightsearchamadeus.model.Airport;
import com.amadeus.restflightsearchamadeus.response.ResponseHandler;
import com.amadeus.restflightsearchamadeus.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    // Read Specific Airport Details from DB
    @GetMapping("{id}")
    public ResponseEntity<Object> getAirportDetails(@PathVariable("id") String id){
        return ResponseHandler.responseBuilder("Requested Airport details are given here.", HttpStatus.OK, airportService.getAirport(id));
    }

    // Read All Airport Details from DB
    @GetMapping()
    public List<Airport> getAllAirportDetails(){
        return airportService.getAllAirport();
    }

    @PostMapping
    public String createAirportDetails(@RequestBody Airport airport){
        airportService.createAirport(airport);
        return "Airport created successfully.";
    }
    @PutMapping
    public String updateAirportDetails(@RequestBody Airport airport){
        airportService.updateAirport(airport);
        return "Airport updated successfully.";
    }

    @DeleteMapping("{id}")
    public String deleteAirportDetails(@PathVariable("id") String id){
        airportService.deleteAirport(id);
        return "Airport deleted successfully.";
    }
}