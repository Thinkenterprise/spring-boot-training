package com.thinkenterprise.repository;


import com.thinkenterprise.domain.aircraft.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AircraftRepositoryImpl implements AircraftRepository {

    @Autowired
    private List<Aircraft> aircraftList;

    @Override
    public Aircraft findByRegistration(String registration) {
        return aircraftList.stream().filter(
                aircraft -> aircraft.getRegistration().equals(registration))
                .findFirst().get();
    }
}
