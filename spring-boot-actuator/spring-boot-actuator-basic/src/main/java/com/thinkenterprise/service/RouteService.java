package com.thinkenterprise.service;

import org.springframework.stereotype.Service;


@Service
public class RouteService {

    private boolean serviceStatus;

    public boolean getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(boolean status) {
        this.serviceStatus = status;
    }
}
