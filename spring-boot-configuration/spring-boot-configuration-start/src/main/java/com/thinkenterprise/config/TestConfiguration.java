package com.thinkenterprise.config;

import com.thinkenterprise.repository.driver.RouteRepositoryDriver;
import com.thinkenterprise.repository.driver.TestRouteRepositoryDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {

    @Bean
    public RouteRepositoryDriver routeRepositoryDriver() {
        return new TestRouteRepositoryDriver();
    }
}
