package com.amadeus.restflightsearchamadeus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlightExceptionHandler {

    @ExceptionHandler(value = {FlightNotFoundException.class})
    public ResponseEntity<Object> handleFlightNotFoundException(FlightNotFoundException flightNotFoundException){
        FlightException flightException = new FlightException(
                flightNotFoundException.getMessage(),
                flightNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(flightException, HttpStatus.NOT_FOUND);
    }
}
