/*
 * Copyright (C) 2016 Thinkenterprise
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * @author Rafael Kansy
 * @author Michael Schaefer
 */

package com.thinkenterprise.message.amqp.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.tracking.Tracking;
import com.thinkenterprise.event.TrackingEventPublisher;
import com.thinkenterprise.repository.TrackingRepository;

@Component
@Profile("requestResponse")
public class AmqpResponseReceiver  {
	private static final Logger logger = LoggerFactory.getLogger(AmqpResponseReceiver.class);
	
	@Autowired
	private TrackingRepository trackingRepository;
	   
	@Autowired
	private TrackingEventPublisher publisher;

    @RabbitListener(queues=AmqpResponseConfiguration.QUEUE_NAME)
    @SendTo(AmqpResponseConfiguration.REPLY_EXCHANGE_NAME )
    //@SendTo(AmqpResponseConfiguration.REPLY_QUEUE_NAME )
	public String onMessage(Tracking tracking) {
	   	trackingRepository.save(tracking);
	    publisher.publishTracking(tracking);
	   	logger.info(tracking.toString());
	   	return "Message Delivered";
	}
   
  
}
