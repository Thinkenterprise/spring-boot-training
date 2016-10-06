package com.thinkenterprise;


import com.thinkenterprise.domain.tracking.FlightStatus;
import com.thinkenterprise.domain.tracking.Tracking;
import com.thinkenterprise.message.jms.JmsSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }

    @Scheduled(fixedDelay = 5000)
    public void sendTracking() {
        Tracking tracking = new Tracking();
        tracking.setRouteId(40L);
        tracking.setFlightNumber("LH7902");
        tracking.setCurrentTime(LocalDateTime.now());
        tracking.setStatus(FlightStatus.DELAYED);

        JmsSender sender = context.getBean(JmsSender.class);
        sender.sendMessage(tracking);
    }
}
