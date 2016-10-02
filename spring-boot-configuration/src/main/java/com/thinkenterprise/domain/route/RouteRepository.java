package com.thinkenterprise.domain.route;

public interface RouteRepository {

    Iterable<Route> findByDeparture(String departure);

    Iterable<Route> findAll();
}
