package com.thinkenterprise.domain.route;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;


public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Query("select f from Flight f where f.date = :date")
    Iterable<Flight> findByDate(@DateTimeFormat(iso = ISO.DATE) @Param("date") LocalDate date);

}
