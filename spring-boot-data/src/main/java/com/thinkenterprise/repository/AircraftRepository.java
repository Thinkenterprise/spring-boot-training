package com.thinkenterprise.repository;

import com.thinkenterprise.domain.aircraft.Aircraft;
import org.springframework.data.repository.CrudRepository;


public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

    Aircraft findByRegistration(String registration);

}
