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

package com.thinkenterprise.message.amqp.response;

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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("requestResponse")
public class AmqpResponseConfiguration {
   
	public static final String QUEUE_NAME 	 = "FlightAwareQueue";
    public static final String EXCHANGE_NAME = "FlightAwareExchange";
    public static final String EXCHANGE_KEY = "FlightAwareKey";
    
    public static final String REPLY_QUEUE_NAME 	 = "ReplyFlightAwareQueue";
    public static final String REPLY_EXCHANGE_NAME = "ReplyFlightAwareExchange";
    public static final String REPLY_EXCHANGE_KEY = "ReplyFlightAwareKey";

    
    @Bean
	public RabbitTemplate fixedReplyQueueRabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setReplyAddress(AmqpResponseConfiguration.REPLY_QUEUE_NAME);
		template.setReplyTimeout(60000L);
		template.setMessageConverter(messageConverter);
		return template;
	}
    
    
    @Bean
	public SimpleMessageListenerContainer replyListenerContainer(RabbitTemplate rabbitTemplate,ConnectionFactory connectionFactory, 
			@Qualifier(AmqpResponseConfiguration.REPLY_QUEUE_NAME) Queue replayQueue) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueues(replayQueue);
		container.setMessageListener(rabbitTemplate);
		return container;
	}
    
    
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }
        
    @Bean(AmqpResponseConfiguration.REPLY_QUEUE_NAME)
    public Queue replyQueue() {
        return new Queue(AmqpResponseConfiguration.REPLY_QUEUE_NAME, false,false,true);
    }
    
    @Bean
    public Queue queue() {
        return new Queue(AmqpResponseConfiguration.QUEUE_NAME, false, false,true);
    }
    
    @Bean(AmqpResponseConfiguration.REPLY_EXCHANGE_NAME)
    public TopicExchange replyExchange() {
        return new TopicExchange(AmqpResponseConfiguration.REPLY_EXCHANGE_NAME);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(AmqpResponseConfiguration.EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(AmqpResponseConfiguration.EXCHANGE_KEY);
    }
    
    @Bean
    public Binding replyBbinding(@Qualifier(AmqpResponseConfiguration.REPLY_QUEUE_NAME) Queue queue,  @Qualifier(AmqpResponseConfiguration.REPLY_EXCHANGE_NAME) TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(AmqpResponseConfiguration.REPLY_EXCHANGE_KEY);
    }

    
   
    
}
