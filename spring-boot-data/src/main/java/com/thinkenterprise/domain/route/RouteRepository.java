package com.thinkenterprise.domain.route;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RouteRepository extends CrudRepository<Route, Long> {

    @Query("select r from Route r where r.departure = :departure")
    Iterable<Route> findByDeparture(@Param("departure") String departure);
}
