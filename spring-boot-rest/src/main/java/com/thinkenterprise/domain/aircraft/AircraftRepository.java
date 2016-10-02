package com.thinkenterprise.domain.aircraft;

import org.springframework.data.repository.CrudRepository;


public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

    Aircraft findByRegistration(String registration);

}
