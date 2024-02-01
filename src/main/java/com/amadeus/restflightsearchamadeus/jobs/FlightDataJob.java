package com.amadeus.restflightsearchamadeus.jobs;

import com.amadeus.restflightsearchamadeus.model.Flight;
import com.amadeus.restflightsearchamadeus.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FlightDataJob {

    private final String apiUrl = "http://localhost:8080/api/v1";

    private final RestTemplate restTemplate;
    private final FlightService flightService;

    @Autowired
    public FlightDataJob(RestTemplate restTemplate, FlightService flightService) {
        this.restTemplate = restTemplate;
        this.flightService = flightService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void fetchFlightAndAirportData() {

        Flight[] flights = restTemplate.getForObject(apiUrl + "/flights", Flight[].class);

        if (flights != null) {
            List<Flight> flightList = Arrays.asList(flights);
            for (Flight flight : flightList){
                flightService.createFlight(flight);
            }
        }
    }
}
