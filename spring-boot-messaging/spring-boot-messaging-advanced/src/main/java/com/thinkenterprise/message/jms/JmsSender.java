package com.thinkenterprise.message.jms;

import com.thinkenterprise.domain.tracking.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Tracking tracking) {
        jmsTemplate.convertAndSend("FlightAwareTracking", tracking);
    }
}
