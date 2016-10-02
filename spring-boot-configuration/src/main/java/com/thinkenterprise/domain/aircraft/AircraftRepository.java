package com.thinkenterprise.domain.aircraft;

public interface AircraftRepository {

    Aircraft findByRegistration(String registration);

}
