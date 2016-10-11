package com.thinkenterprise;


import com.thinkenterprise.config.RouteProperties;
import com.thinkenterprise.service.RouteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(RouteProperties.class)
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        RouteService routeService = context.getBean(RouteService.class);
        routeService.findAll();
    }
}
