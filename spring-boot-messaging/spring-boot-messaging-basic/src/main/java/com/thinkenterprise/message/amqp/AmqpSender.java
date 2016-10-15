package com.thinkenterprise.message.amqp;

import com.thinkenterprise.domain.tracking.Tracking;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmqpSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Tracking tracking) {
        rabbitTemplate.convertAndSend(AmqpConfiguration.QUEUE_NAME, tracking);
    }
}
