package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Flight;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;


public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {

    @Cacheable("flightsByDate")
    @Query("select f from Flight f where f.date = :date")
    Iterable<Flight> findByDate(@DateTimeFormat(iso = ISO.DATE) @Param("date") LocalDate date);

}
