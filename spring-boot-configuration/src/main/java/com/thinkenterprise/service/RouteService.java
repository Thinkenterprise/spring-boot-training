package com.thinkenterprise.service;

import com.thinkenterprise.domain.route.Route;
import org.springframework.stereotype.Service;

import java.time.LocalTime;


@Service("routeService")
public class RouteService {

    public int calculateFlightCount(Route route) {
        return route.getFlights().size();
    }

    public String formatTime(LocalTime time) {
        return time.toString();
    }
}
