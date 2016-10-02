package com.thinkenterprise.domain.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Repository
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private List<Route> routeList;

    @Override
    public Iterable<Route> findByDeparture(String departure) {
        return routeList.stream().filter(
                route -> route.getDeparture().equals(departure)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> findAll() {
        return routeList.subList(0, routeList.size());
    }
}