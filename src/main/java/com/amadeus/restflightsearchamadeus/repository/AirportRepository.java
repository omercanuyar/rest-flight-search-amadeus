package com.amadeus.restflightsearchamadeus.repository;

import com.amadeus.restflightsearchamadeus.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {

}
