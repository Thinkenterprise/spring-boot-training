package com.thinkenterprise.customize;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldSpringApplicationEventListener implements ApplicationListener<ApplicationEvent> {


	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Hello World Application Initalizeation: Receive Initalizeation Message " + event.toString());
	}

}
