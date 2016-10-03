package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;

public interface RouteRepository {

    Iterable<Route> findByDeparture(String departure);

    Iterable<Route> findAll();
}
