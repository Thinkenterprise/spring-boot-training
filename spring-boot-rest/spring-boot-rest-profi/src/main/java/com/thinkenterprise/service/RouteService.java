package com.thinkenterprise.service;

import com.thinkenterprise.controller.RouteNotFoundException;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;


@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public int calculateFlightCount(Route route) {
        return route.getFlights().size();
    }

    public String formatTime(LocalTime time) {
        return time.toString();
    }

    public Iterable<Route> findAll() {
        return routeRepository.findAll();
    }

    public Iterable<Route> findByDeparture(String departure) {
        return routeRepository.findByDeparture(departure);
    }

    public boolean exists(long id) throws RouteNotFoundException {
        boolean result = routeRepository.exists(id);
        if (!result) {
            throw new RouteNotFoundException("Route not found: " + id);
        } else {
            return result;
        }
    }

    public long count() {
        return routeRepository.count();
    }

    public void delete(long id) {
        routeRepository.delete(id);
    }

    public Route save(Route entity) {
        return routeRepository.save(entity);
    }

    public Route findById(long id) {
        return routeRepository.findOne(id);
    }
}
