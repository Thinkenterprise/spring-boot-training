package com.thinkenterprise.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RouteServiceHealthIndicator implements HealthIndicator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteService.class);

    @Autowired
    private RouteService service;

    @Override
    public Health health() {
        boolean serviceStatus = service.getServiceStatus();
        if (serviceStatus) {
            LOGGER.info("RouteService status: down");
            return Health.up().build();
        } else {
            LOGGER.warn("RouteService status: up");
            return Health.down().build();
        }
    }
}
