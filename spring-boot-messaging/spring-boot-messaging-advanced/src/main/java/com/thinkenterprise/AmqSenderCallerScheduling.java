package com.thinkenterprise;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.tracking.FlightStatus;
import com.thinkenterprise.domain.tracking.Tracking;
import com.thinkenterprise.message.amqp.AmqpSender;

@Component
@Profile("!requestResponse")
public class AmqSenderCallerScheduling implements BeanFactoryAware{

	public static Long counter = new Long(0);
	
	 private static BeanFactory context;
	
	 @Scheduled(initialDelay = 5000, fixedDelay = 5000)
	    public void sendTracking() {
	        Tracking tracking = new Tracking();
	        tracking.setRouteId(counter++);
	        tracking.setFlightNumber("LH7902");
	        tracking.setStatus(FlightStatus.DELAYED);

	        AmqpSender sender = context.getBean(AmqpSender.class);
	        sender.sendMessage(tracking);
	    }

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.context=beanFactory;
		
	}
	 
}
