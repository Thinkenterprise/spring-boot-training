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

package com.thinkenterprise.repository;

import com.thinkenterprise.domain.route.Route;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@DataJpaTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class RouteRepositoryDataJpaTest {

  
    @Autowired
    private RouteRepository repository;

   
    @Test
    public void create() throws Exception {
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

        repository.saveAll(entities);
        
        long actual = repository.count();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void findOne() throws Exception {
        Route expected = new Route("LH401", "FRA", "NYC");
    
        Route actual = repository.findById(103L).get();

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
        Iterable<Route> actual = repository.findByDeparture("MUC");
        Assert.assertEquals("MUC", actual.iterator().next().getDeparture());
    }

    @Test
    public void queryFindByDeparture() throws Exception {
        Iterable<Route> actual = repository.queryFindByDeparture("MUC");
        Assert.assertEquals("MUC", actual.iterator().next().getDeparture());
    }

    @Test
    public void findByDestination() throws Exception {
        Iterable<Route> actual = repository.findByDestination("IAH");
        Assert.assertEquals("IAH", actual.iterator().next().getDestination());
    }

    @Test
    public void update() throws Exception {
        
        Route expected = repository.findById(103L).get();
        expected.setDestination("BAR");
        repository.save(expected);

        Route actual = repository.findById(103L).get();
        Assert.assertEquals(expected.getFlightNumber(), actual.getFlightNumber());
        Assert.assertEquals(expected.getDeparture(), actual.getDeparture());
        Assert.assertEquals(expected.getDestination(), actual.getDestination());
    }

    @Test
    public void delete() throws Exception {
        long expected = repository.count() - 1;

        repository.deleteById(102L);

        long actual = repository.count();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAll() throws Exception {
        long expected = 0;

        repository.deleteAll();

        long actual = repository.count();
        Assert.assertEquals(expected, actual);
    }
}