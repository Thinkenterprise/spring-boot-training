package com.thinkenterprise.controller;

import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/routes2")
public class RouteController {

    @Autowired
    private RouteService service;

    @RequestMapping("/count")
    @PreAuthorize("isAuthenticated() and hasPermission('com.thinkenterprise.domain.route.Route', 'read')")
    public long count() {
        return service.count();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("isAuthenticated() and hasPermission('com.thinkenterprise.domain.route.Route', 'write')")
    public void delete(@PathVariable(value = "id") Long id) throws RouteNotFoundException {
        try {
            service.exists(id);
            service.delete(id);
        } catch (RouteNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() and hasPermission('com.thinkenterprise.domain.route.Route', 'read')")
    public Route get(@PathVariable(value = "id") Long id) throws RouteNotFoundException {
        try {
            service.exists(id);
            return service.findById(id);
        } catch (RouteNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("isAuthenticated() and hasPermission('com.thinkenterprise.domain.route.Route', 'write')")
    public Route put(@Valid @RequestBody Route entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated() and hasPermission('com.thinkenterprise.domain.route.Route', 'write')")
    public Route post(@Valid @RequestBody Route entity) {
        return service.save(entity);
    }

    @RequestMapping("/")
    @PreAuthorize("isAuthenticated() and hasPermission('com.thinkenterprise.domain.route.Route', 'read')")
    public Iterable<Route> findAll() {
        return service.findAll();
    }

    @RequestMapping("/search/findByDeparture")
    @PreAuthorize("isAuthenticated() and hasPermission('com.thinkenterprise.domain.route.Route', 'read')")
    public Iterable<Route> findByDeparture(@RequestParam(value = "departure") String departure) {
        return service.findByDeparture(departure);
    }
}
