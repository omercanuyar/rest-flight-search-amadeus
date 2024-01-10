package com.amadeus.restflightsearchamadeus.repository;

import com.amadeus.restflightsearchamadeus.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, String> {
}
