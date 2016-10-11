package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RouteRepository extends CrudRepository<Route, Long> {
    Iterable<Route> findByDeparture(@Param("departure") String departure);

    @Query(value = "select r from Route r where r.departure = :departure")
    Iterable<Route> queryFindByDeparture(@Param("departure") String departure);

    @Query(value = "select r from Route r where r.destination = :destination")
    Iterable<Route> findByDestination(@Param("destination") String destination);
}
