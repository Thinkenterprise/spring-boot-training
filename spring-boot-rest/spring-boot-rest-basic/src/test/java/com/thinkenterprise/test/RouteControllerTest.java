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

import com.thinkenterprise.controller.RouteErrorStatus;
import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.Route;

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
       
    @Test
    public void post() {
    	  	
    	  Route route = new Route("TEST100", "TEST1", "TEST2");
          route.addScheduledDaily();
          route.setDepartureTime(LocalTime.of(9, 30));
          route.setArrivalTime(LocalTime.of(14, 00));

          Flight flight = new Flight(120.45, LocalDate.of(2015, 9, 23));
          flight.addEmployee("Fred");
          flight.addEmployee("Sarah");
          route.addFlight(flight);

          flight = new Flight(111.45, LocalDate.of(2015, 9, 24));
          route.addFlight(flight);
 
          ResponseEntity<Route> result = restTemplate.postForEntity("/routes", route, Route.class);
    	
          Assert.assertEquals (HttpStatus.CREATED, result.getStatusCode());
          Assert.assertNotNull (result.getBody());
          Assert.assertEquals ("TEST100", result.getBody().getFlightNumber());
             	   		
    }
         
    
    @Test
    public void get()  {
    	
        Map<String, String> keys = new HashMap<>();
        keys.put("id", "10");

        // 1. Option with restTemplate.getForObject
        Route route = this.restTemplate.getForObject("/routes/{id}", Route.class, keys);
        Assert.assertNotNull(route);

        // 2. Option with restTemplate.getForEntity
        ResponseEntity<Route> routeEntity = this.restTemplate.getForEntity("/routes/{id}", Route.class, keys);
        Assert.assertEquals (HttpStatus.OK, routeEntity.getStatusCode());
        Assert.assertNotNull (routeEntity.getBody());
        Assert.assertEquals (10L, routeEntity.getBody().getId().longValue());

        // 3. Option with restTemplate.exchange
        ResponseEntity<Route> routeEntity2 = this.restTemplate.exchange("/routes/{id}", HttpMethod.GET, null, Route.class, keys);
        Assert.assertEquals (HttpStatus.OK, routeEntity2.getStatusCode());
        Assert.assertNotNull (routeEntity2.getBody());
        Assert.assertEquals (10L, routeEntity2.getBody().getId().longValue());
    }

   

    @Test
    public void getAllWithIteratbel()  {

        // 1. Option with Iterator and restTemplate.getForObject
        Iterable<Route> iterable = this.restTemplate.getForObject("/routes", Iterable.class);
        
        int size=0;
        for (Iterator<Route> iterator=iterable.iterator(); iterator.hasNext() ; ++size, iterator.next() ) ;
        
        Assert.assertNotNull(iterable.iterator().hasNext());
      
    }

    @Test
    public void getAllWithParameterized()  {

        // 2. Option with Iterator and restTemplate.exchange
        ResponseEntity<Iterable<Route>> routeResponse =
                restTemplate.exchange("/routes",
                            HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Route>>(){});
        
        Iterable<Route> iterable = routeResponse.getBody();        
        int size=0;
        for (Iterator<Route> iterator=iterable.iterator(); iterator.hasNext() ; ++size, iterator.next() ) ;

        Assert.assertEquals (HttpStatus.OK, routeResponse.getStatusCode());
        Assert.assertNotNull (routeResponse.getBody());
        Assert.assertNotNull(iterable.iterator().hasNext());
        
    }
    
    @Test
    public void getAllWithParameterizedWithList() {

        // 3. Option with List and restTemplate.exchange
        ResponseEntity<List<Route>> routeResponse =
                restTemplate.exchange("/routes",
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Route>>(){});
        
        List<Route> routes = routeResponse.getBody();        

        Assert.assertEquals (HttpStatus.OK, routeResponse.getStatusCode());
        Assert.assertNotNull (routeResponse.getBody());
        
    }
    
    @Test
    public void getNotFound() throws Exception {
    	
        Map<String, String> keys = new HashMap<>();
        keys.put("id", "40");

        ResponseEntity<RouteErrorStatus> error = this.restTemplate.getForEntity("/routes/{id}", RouteErrorStatus.class, keys);
        
        Assert.assertEquals(HttpStatus.NOT_FOUND, error.getStatusCode());
        Assert.assertEquals(6573, error.getBody().getFunctionalErrorCode());
    }
}