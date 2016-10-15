package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;


public interface FlightRepository extends CrudRepository<Flight, Long> {

    Iterable<Flight> findByDate(@DateTimeFormat(iso = ISO.DATE) @Param("date") LocalDate date);

}
