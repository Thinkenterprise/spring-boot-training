package com.thinkenterprise.domain.route;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.thinkenterprise.domain.core.AbstractEntity;

@Entity
public class Route extends AbstractEntity {

	private String flightNumber;
	private String departure;
	private String destination;
	
	@OneToMany(mappedBy = "route", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Flight> flights = new ArrayList<>();

	public Route() {
		super();
	}

	public Route(String flightNumber) {
		super();
		this.flightNumber = flightNumber;
	}

	public Route(String flightNumber, String departure, String destination) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.departure = departure;
	}


	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String number) {
		this.flightNumber = number;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}

}
