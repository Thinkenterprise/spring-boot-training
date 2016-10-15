package com.thinkenterprise.config;

import com.thinkenterprise.repository.driver.DefaultRouteRepositoryDriver;
import com.thinkenterprise.repository.driver.RouteRepositoryDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfiguration {

    @Bean
    public RouteRepositoryDriver routeRepositoryDriver() {
        return new DefaultRouteRepositoryDriver();
    }
}
