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
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.tracking.Tracking;

@Component
public class AmqpResponseSender {
	
	private static final Logger logger = LoggerFactory.getLogger(AmqpResponseSender.class);
	
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Tracking tracking) {
        String response = (String) rabbitTemplate.convertSendAndReceive(AmqpResponseConfiguration.EXCHANGE_NAME, AmqpResponseConfiguration.EXCHANGE_KEY, tracking);
        logger.info(response);
    }
}
