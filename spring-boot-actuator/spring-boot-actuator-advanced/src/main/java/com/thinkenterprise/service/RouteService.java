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

package com.thinkenterprise.service;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;


@Service
public class RouteService {
  
    private boolean serviceStatus;
    private final Counter counter;
    
   
	public RouteService(MeterRegistry registry) {
		this.counter = registry.counter("change.status");
	}


	public boolean getServiceStatus() {
		this.counter.increment();
        return serviceStatus;
    }

    public void setServiceStatus(boolean status) {
        this.serviceStatus = status;
    }
}
