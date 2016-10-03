package com.thinkenterprise.domain;

import com.thinkenterprise.domain.aircraft.Aircraft;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class BoundedContextTestInitializer {

    @Bean
    public List<Aircraft> aircraftList() {
        List<Aircraft> result = new ArrayList<>();
        result.add(new Aircraft("B764", "D-BILA"));
        result.add(new Aircraft("A320", "D-AIPA"));
        result.add(new Aircraft("B737", "D-BTXT"));
        result.add(new Aircraft("A380", "D-AMUC"));
        return result;
    }
}
