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
 * @author Michael Schaefer
 */

package com.thinkenterprise.message.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!requestResponse")
public class AmqpConfiguration {
   
	public static final String SIMPLE_QUEUE_NAME 	 = "SimpleFlightAwareQueue";
    public static final String SIMPLE_EXCHANGE_NAME = "SimpleFlightAwareExchange";
    public static final String SIMPLE_EXCHANGE_KEY = "SimpleFlightAwareKey";

    @Bean
    public Queue queue() {
        return new Queue(AmqpConfiguration.SIMPLE_QUEUE_NAME, false, false,true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(AmqpConfiguration.SIMPLE_EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(AmqpConfiguration.SIMPLE_EXCHANGE_KEY);
    }

    
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }
    
}
