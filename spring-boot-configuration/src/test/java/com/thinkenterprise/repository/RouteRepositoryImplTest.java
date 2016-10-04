package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RouteRepositoryImplTest {

    @Autowired
    private RouteRepository sut;

    @Test
    public void findByDeparture() throws Exception {
        Iterable<Route> actual = sut.findByDeparture("FRA");
        Assert.assertNotNull(actual.iterator().hasNext());
    }

    @Test
    public void findAll() throws Exception {
        Iterable<Route> actual = sut.findAll();
        Assert.assertNotNull(actual.iterator().hasNext());
    }
}