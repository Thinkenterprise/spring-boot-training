package com.thinkenterprise.domain.tracking;

import com.thinkenterprise.domain.core.AbstractEntity;

import java.time.LocalDateTime;

public class Tracking extends AbstractEntity {
    private Long routeId;
    private String flightNumber;
    private LocalDateTime currentTime;
    private FlightStatus status;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }
}
