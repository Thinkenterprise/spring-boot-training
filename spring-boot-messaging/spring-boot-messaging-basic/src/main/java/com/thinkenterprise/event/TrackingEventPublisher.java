package com.thinkenterprise.event;

import com.thinkenterprise.domain.tracking.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TrackingEventPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publishTracking(Tracking tracking) {
        this.publisher.publishEvent(new TrackingEvent(tracking));
    }
}
