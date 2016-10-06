package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.repository.driver.RouteRepositoryDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private RouteRepositoryDriver driver;

    @Override
    public Iterable<Route> findByDeparture(String departure) {
        return driver.getRouteList().stream().filter(
                route -> route.getDeparture().equals(departure)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> findAll() {
        return driver.getRouteList().subList(0, driver.getRouteList().size());
    }
}
