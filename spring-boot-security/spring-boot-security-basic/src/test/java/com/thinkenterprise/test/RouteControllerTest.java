package com.thinkenterprise.test;


import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.thinkenterprise.domain.route.Route;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RouteControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAll() throws IOException { 
    	
    	        ResponseEntity<List<Route>> routeResponse =
    	        		testRestTemplate.exchange("/routes",
    	                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Route>>(){});
    	        
    	        Assert.assertEquals (HttpStatus.OK, routeResponse.getStatusCode());
    	        Assert.assertNotNull (routeResponse.getBody());
    	       
    }
   
}