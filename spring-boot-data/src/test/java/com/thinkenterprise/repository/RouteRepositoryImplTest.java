package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class RouteRepositoryImplTest {

    @Autowired
    private RouteRepository repository;

    @Test
    public void create () throws Exception {
        long expected = repository.count() + 1;

        Route entity = new Route("LH400", "MUC", "NYC");
        repository.save(entity);

        long actual = repository.count();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createIterable() throws Exception {
        long expected = repository.count() + 2;

        List<Route> entities = new ArrayList<>();
        entities.add(new Route("LH400", "MUC", "NYC"));
        entities.add(new Route("LH450", "NYC", "MUC"));

        repository.save(entities);

        long actual = repository.count();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exists() throws Exception {
        boolean actual = repository.exists(40L);

        Assert.assertEquals(true, actual);
    }


    @Test
    public void findOne() throws Exception {
        Route expected = new Route("LH7902", "MUC", "IAH");

        Route actual = repository.findOne(40L);

        Assert.assertEquals(expected.getFlightNumber(), actual.getFlightNumber());
        Assert.assertEquals(expected.getDeparture(), actual.getDeparture());
        Assert.assertEquals(expected.getDestination(), actual.getDestination());
    }

    @Test
    public void findAll() throws Exception {
        Iterable<Route> actual = repository.findAll();
        Assert.assertNotNull(actual.iterator().hasNext());
    }

    @Test
    public void findByDeparture() throws Exception {
        Iterable<Route> actual = repository.findByDeparture("FRA");
        Assert.assertEquals("FRA", actual.iterator().next().getDeparture());
    }

    @Test
    public void update () throws Exception {
        Route expected = new Route("LH7902", "MUC", "BAR");

        Route entity = repository.findOne(40L);
        entity.setDestination("BAR");
        repository.save(entity);

        Route actual = repository.findOne(40L);
        Assert.assertEquals(expected.getFlightNumber(), actual.getFlightNumber());
        Assert.assertEquals(expected.getDeparture(), actual.getDeparture());
        Assert.assertEquals(expected.getDestination(), actual.getDestination());
    }

    @Test
    public void delete() throws Exception {
        long expected = repository.count() - 1 ;

        repository.delete(40L);

        long actual = repository.count();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAll() throws Exception {
        long expected = 0 ;

        repository.deleteAll();

        long actual = repository.count();
        Assert.assertEquals(expected, actual);
    }
}