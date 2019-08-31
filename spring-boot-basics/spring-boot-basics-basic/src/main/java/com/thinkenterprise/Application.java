/*
 * Copyright (C) 2018 Thinkenterprise
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

package com.thinkenterprise;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;

import com.thinkenterprise.customize.HelloWorldSpringApplicationContextInitializer;
import com.thinkenterprise.customize.HelloWorldSpringApplicationEventListener;

@SpringBootApplication(exclude = {H2ConsoleAutoConfiguration.class}, scanBasePackageClasses = {Application.class})
public class Application implements ApplicationRunner  {
	
	
    public static void main(String[] args) {
    	
    	SpringApplication springApplication = new SpringApplication(Application.class);
    	
    	springApplication.addListeners(new HelloWorldSpringApplicationEventListener());
    	springApplication.addInitializers(new HelloWorldSpringApplicationContextInitializer());
    	springApplication.run(args);    	

    }


	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Here you can initialize your application ...");
		System.out.println(args.getSourceArgs());
		
	}
}
