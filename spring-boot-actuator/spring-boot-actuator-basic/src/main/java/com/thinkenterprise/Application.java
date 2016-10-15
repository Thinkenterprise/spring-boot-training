package com.thinkenterprise;


import com.thinkenterprise.service.RouteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }

    @Scheduled(fixedDelay = 10000)
    public void changeStatus() {
        RouteService service = context.getBean(RouteService.class);
        service.setServiceStatus(!service.getServiceStatus());
    }
}
