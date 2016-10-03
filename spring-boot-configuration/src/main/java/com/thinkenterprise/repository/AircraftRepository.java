package com.thinkenterprise.repository;

import com.thinkenterprise.domain.aircraft.Aircraft;

public interface AircraftRepository {

    Aircraft findByRegistration(String registration);

}
