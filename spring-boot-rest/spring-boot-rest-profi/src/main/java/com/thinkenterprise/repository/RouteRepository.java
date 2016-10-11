package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {

    @Cacheable("routesByDeparture")
    @Query("select r from Route r where r.departure = :departure")
    Iterable<Route> findByDeparture(@Param("departure") String departure);
}
