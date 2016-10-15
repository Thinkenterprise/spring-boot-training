package com.thinkenterprise.config;

import com.thinkenterprise.repository.RouteRepositoryImpl;
import com.thinkenterprise.repository.driver.RouteRepositoryDriver;
import com.thinkenterprise.repository.driver.TestRouteRepositoryDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
@ConditionalOnClass(RouteRepositoryImpl.class)
public class TestConfiguration {

    @Bean
    public RouteRepositoryDriver routeRepositoryDriver() {
        return new TestRouteRepositoryDriver();
    }
}
