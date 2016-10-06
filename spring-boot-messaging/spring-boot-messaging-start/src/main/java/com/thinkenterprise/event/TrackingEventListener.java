package com.thinkenterprise.event;

import com.thinkenterprise.message.amqp.AmqpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TrackingEventListener {

    @Autowired
    private AmqpSender amqpSender;

    @EventListener
    public void handleTrackingEvent(TrackingEvent event) {
        amqpSender.sendMessage(event.getTracking());
    }
}
