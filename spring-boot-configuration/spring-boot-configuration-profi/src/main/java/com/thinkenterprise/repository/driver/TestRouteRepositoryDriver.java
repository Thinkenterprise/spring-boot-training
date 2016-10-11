package com.thinkenterprise.repository.driver;

import com.thinkenterprise.config.RouteProperties;
import com.thinkenterprise.domain.route.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestRouteRepositoryDriver implements RouteRepositoryDriver {

    @Autowired
    private RouteProperties routeConfiguration;

    private List<Route> routeList = new ArrayList<>();

    @PostConstruct
    public void initRoutesList() {
        for (short i = 0; i < routeConfiguration.getCount(); i++) {
            String flightNumber = routeConfiguration.getFlightNumber();
            String departure = routeConfiguration.getDeparture();
            String destination = routeConfiguration.getDestination();

            Route route = new Route(flightNumber, departure, destination);
            route.addScheduledDaily();
            route.setDepartureTime(LocalTime.of(9 - i, 30));
            route.setArrivalTime(LocalTime.of(14 - i, 0));
            routeList.add(route);
        }
    }

    @Override
    public List<Route> getRouteList() {
        return routeList;
    }
}
