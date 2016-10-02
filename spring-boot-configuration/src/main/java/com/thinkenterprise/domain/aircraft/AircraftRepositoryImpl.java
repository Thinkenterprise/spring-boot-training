package com.thinkenterprise.domain.aircraft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
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
