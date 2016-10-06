package com.thinkenterprise.message.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class AmqpReceiver implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(AmqpReceiver.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info(new String(message.getBody()));
    }
}
