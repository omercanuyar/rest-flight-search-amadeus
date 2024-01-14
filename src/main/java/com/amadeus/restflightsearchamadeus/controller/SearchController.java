package com.amadeus.restflightsearchamadeus.controller;

import com.amadeus.restflightsearchamadeus.model.Flight;
import com.amadeus.restflightsearchamadeus.response.SearchResponse;
import com.amadeus.restflightsearchamadeus.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SearchController {

    private final FlightService flightService;

    @Autowired
    public SearchController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public SearchResponse searchFlights(
            @RequestParam String departure,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnDate) {

        List<Flight> gidis = flightService.searchFlights(departure,destination,departureDate);
        List<Flight> donus;
        SearchResponse searchResponse = new SearchResponse();

        if (returnDate != null){
            donus = flightService.searchFlights(destination,departure,returnDate);
            searchResponse.donus = donus;
        }

        searchResponse.gidis = gidis;

        return searchResponse;
    }
}
