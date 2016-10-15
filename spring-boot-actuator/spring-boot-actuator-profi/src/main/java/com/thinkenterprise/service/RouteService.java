package com.thinkenterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;


@Service
public class RouteService {
    @Autowired
    private CounterService counterService;

    private boolean serviceStatus;

    public boolean getServiceStatus() {
        this.counterService.increment("services.system.routeservice.invoked");
        return serviceStatus;
    }

    public void setServiceStatus(boolean status) {
        this.serviceStatus = status;
    }
}
