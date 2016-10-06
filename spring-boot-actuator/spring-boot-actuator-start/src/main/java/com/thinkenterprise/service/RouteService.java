package com.thinkenterprise.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


@Service("routeService")
public class RouteService {

    private final AtomicInteger counter = new AtomicInteger(0);

    public boolean getServiceStatus() {
        return counter.incrementAndGet() % 2 == 0;
    }
}
