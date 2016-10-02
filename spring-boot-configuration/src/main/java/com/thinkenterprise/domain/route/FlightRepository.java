package com.thinkenterprise.domain.route;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;


interface FlightRepository {

    Iterable<Flight> findByDate(@DateTimeFormat(iso = ISO.DATE) LocalDate date);
}
