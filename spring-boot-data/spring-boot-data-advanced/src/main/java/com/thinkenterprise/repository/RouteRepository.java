package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RouteRepository extends CrudRepository<Route, Long> {
    Iterable<Route> findByDeparture(@Param("departure") String departure);

    Iterable<Route> findByDestination(@Param("destination") String destination);
}
