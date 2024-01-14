package com.amadeus.restflightsearchamadeus.repository;

import com.amadeus.restflightsearchamadeus.model.Airport;
import com.amadeus.restflightsearchamadeus.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    public List<Flight> findFlightByDepartureAirportAndArrivalAirportAndDate(Airport departureAirport, Airport arrivalAirport, Date date);
}
