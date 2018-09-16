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
 * 
 * @author Michael Schaefer
 */

package com.thinkenterprise.controller;

import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService service;

    @RequestMapping("count")
    @PreAuthorize("hasRole('ADMIN')")
    public long count() {
        return service.count();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws RouteNotFoundException {
        try {
            service.exists(id);
            service.delete(id);
            return ResponseEntity.accepted().build();
        } catch (RouteNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Route> get(@PathVariable(value = "id") Long id) throws RouteNotFoundException {
        try {
            service.exists(id);
            return ResponseEntity.ok(service.findById(id));
        } catch (RouteNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Route> put(@Valid @RequestBody Route entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Route> post(@Valid @RequestBody Route entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @RequestMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Iterable<Route>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

  
}

