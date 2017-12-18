package com.thinkenterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.repository.jdbc.JdbcRouteRepository;

@RestController
@RequestMapping("/routes")
public class RouteController {
	
	@Autowired
	private JdbcRouteRepository jpaRouteRepository;
	
	@RequestMapping
	public List<Route> getAll() {
		return jpaRouteRepository.findAll();
	}
	
	@RequestMapping("{id}")
	public Route get(@PathVariable Integer id) {
		return jpaRouteRepository.find(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Route post(@RequestBody Route route) {
		return jpaRouteRepository.save(route);
	}
	
}
