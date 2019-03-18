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

package com.thinkenterprise.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.thinkenterprise.controller.RouteErrorStatus;
import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.repository.RouteRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RouteControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private RouteRepository routeRepository;

	@Test
	public void post() {

		Route route = new Route("LH2345", "DUS", "BER");

		Flight flight = new Flight(120.45, LocalDate.of(2015, 9, 23));
		route.addFlight(flight);

		flight = new Flight(111.45, LocalDate.of(2015, 9, 24));
		route.addFlight(flight);

		ResponseEntity<Route> result = restTemplate.postForEntity("/routes", route, Route.class);

		Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
		Assert.assertNotNull(result.getBody());
		Assert.assertEquals("LH2345", result.getBody().getFlightNumber());

	}
	
	@Test
	public void postValidated() {

		Route route = new Route(null, "DUS", "BER");

		Flight flight = new Flight(120.45, LocalDate.of(2015, 9, 23));
		route.addFlight(flight);

		flight = new Flight(111.45, LocalDate.of(2015, 9, 24));
		route.addFlight(flight);

		ResponseEntity<Route> result = restTemplate.postForEntity("/routes", route, Route.class);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test
	public void update() {

		Map<String, String> keys = new HashMap<>();
		keys.put("id", "101");

		Route route = new Route("LH2345", "DUS", "MUC");
		route.setId(101L);

		restTemplate.put("/routes", route, keys);

		Route changedRoute = routeRepository.findById(101L).get();

		Assert.assertEquals(route.getFlightNumber(), changedRoute.getFlightNumber());

	}

	@Test
    public void delete() {
    	  	
    	Map<String, String> keys = new HashMap<>();
        keys.put("id", "103");
 
        restTemplate.delete("/routes/{id}", keys);          
          
        Optional optional = routeRepository.findById(103L);
        
        Assert.assertTrue(!optional.isPresent());
	}

	@Test
	public void get() {

		Map<String, String> keys = new HashMap<>();
		keys.put("id", "101");

		ResponseEntity<Route> routeEntity = this.restTemplate.getForEntity("/routes/{id}", Route.class, keys);
		Assert.assertEquals(HttpStatus.OK, routeEntity.getStatusCode());
		Assert.assertNotNull(routeEntity.getBody());
		Assert.assertEquals(101L, routeEntity.getBody().getId().longValue());

	}

	@Test
	public void getNotFound() throws Exception {

		Map<String, String> keys = new HashMap<>();
		keys.put("id", "110000");
		ResponseEntity<RouteErrorStatus> error = this.restTemplate.getForEntity("/routes/{id}", RouteErrorStatus.class,
				keys);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
		Assert.assertEquals(6573, error.getBody().getFunctionalErrorCode());
	}

	@Test
	public void getAll() {

		ResponseEntity<Iterable<Route>> routeResponse = restTemplate.exchange("/routes", HttpMethod.GET, null,
				new ParameterizedTypeReference<Iterable<Route>>() {
				});

		Iterable<Route> iterable = routeResponse.getBody();

		Assert.assertEquals(HttpStatus.OK, routeResponse.getStatusCode());
		Assert.assertNotNull(routeResponse.getBody());
		Assert.assertNotNull(iterable.iterator().hasNext());

	}

}