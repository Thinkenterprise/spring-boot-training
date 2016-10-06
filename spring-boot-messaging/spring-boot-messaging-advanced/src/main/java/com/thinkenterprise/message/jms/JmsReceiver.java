package com.thinkenterprise.message.jms;

import com.thinkenterprise.domain.tracking.Tracking;
import com.thinkenterprise.event.TrackingEventPublisher;
import com.thinkenterprise.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver {
    @Autowired
    private TrackingRepository trackingRepository;
    @Autowired
    private TrackingEventPublisher publisher;

    @JmsListener(destination = "FlightAwareTracking", containerFactory = "jmsFactory")
    public void receiveMessage(Tracking tracking) {
        trackingRepository.save(tracking);
        publisher.publishTracking(tracking);
    }
}
