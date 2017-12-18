package com.thinkenterprise.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinkenterprise.domain.route.Route;

@RestController
@RequestMapping("/routes")
public class RouteController {
			
	@RequestMapping
	public List<Route> getAll() {
		return null;
	}
	
	@RequestMapping("{id}")
	public Route get(@PathVariable Integer id) {
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Route post(@RequestBody Route route) {
		return null;
	}
	
}
