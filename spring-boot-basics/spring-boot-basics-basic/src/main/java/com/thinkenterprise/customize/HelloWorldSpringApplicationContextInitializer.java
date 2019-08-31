package com.thinkenterprise.customize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class HelloWorldSpringApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("Hello World Application Initalizeation: Initialize the application context");
		
	}

}
