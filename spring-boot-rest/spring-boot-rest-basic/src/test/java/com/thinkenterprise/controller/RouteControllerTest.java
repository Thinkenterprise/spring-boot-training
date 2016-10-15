package com.thinkenterprise.controller;

import com.thinkenterprise.domain.route.Route;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RouteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void get() throws Exception {
        Map<String, String> keys = new HashMap<>();
        keys.put("id", "40");

        Route body = this.restTemplate.getForObject("/routes2/{id}", Route.class, keys);
        Assert.assertNotNull(body);
    }
}