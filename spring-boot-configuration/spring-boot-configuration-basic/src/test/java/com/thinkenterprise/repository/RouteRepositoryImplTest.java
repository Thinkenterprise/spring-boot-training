package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class RouteRepositoryImplTest {

    @Autowired
    private RouteRepository repository;

    @Test
    public void findByDeparture() throws Exception {
        Iterable<Route> actual = repository.findByDeparture("FRA");
        Assert.assertNotNull(actual.iterator().hasNext());
    }

    @Test
    public void findAll() throws Exception {
        Iterable<Route> actual = repository.findAll();
        Assert.assertNotNull(actual.iterator().hasNext());
    }
}