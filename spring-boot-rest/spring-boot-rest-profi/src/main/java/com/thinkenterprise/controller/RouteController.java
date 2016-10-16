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

package com.thinkenterprise.controller;

import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/routes2")
public class RouteController {

    @Autowired
    private RouteService service;

    @RequestMapping("/count")
    public long count() {
        return service.count();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) throws RouteNotFoundException {
        try {
            service.exists(id);
            service.delete(id);
        } catch (RouteNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Route get(@PathVariable(value = "id") Long id) throws RouteNotFoundException {
        try {
            service.exists(id);
            return service.findById(id);
        } catch (RouteNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Route put(@Valid @RequestBody Route entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Route post(@Valid @RequestBody Route entity) {
        return service.save(entity);
    }

    @RequestMapping("/")
    public Iterable<Route> findAll() {
        return service.findAll();
    }

    @RequestMapping("/search/findByDeparture")
    public Iterable<Route> findByDeparture(@RequestParam(value = "departure") String departure) {
        return service.findByDeparture(departure);
    }
}
