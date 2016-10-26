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

package com.thinkenterprise.domain.route;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;

import com.thinkenterprise.domain.core.AbstractEntity;


@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(name = "routeFlight", attributeNodes = {@NamedAttributeNode("flights")}),
})
public class Route extends AbstractEntity {

    private String flightNumber;
    private String departure;
    private String destination;

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection(targetClass = DayOfWeek.class)
    private Set<DayOfWeek> scheduledWeekdays = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn(name = "date")
    private List<Flight> flights = new ArrayList<>();

    @Transient
    private Double total;

    public Route() {
        super();
    }

    public Route(String flightNumber) {
        super();
        this.flightNumber = flightNumber;
    }

    public Route(String flightNumber, String departure, String destination) {
        super();
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

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime time) {
        this.departureTime = time;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime time) {
        this.arrivalTime = time;
    }

    public Set<DayOfWeek> getScheduledWeekdays() {
        return scheduledWeekdays;
    }

    public void setScheduledWeekdays(Set<DayOfWeek> scheduledWeekday) {
        this.scheduledWeekdays = scheduledWeekday;
    }

    public void addScheduledWeekday(DayOfWeek scheduledWeekday) {
        this.scheduledWeekdays.add(scheduledWeekday);
    }

    public void addScheduledDaily() {
        this.scheduledWeekdays.add(DayOfWeek.MONDAY);
        this.scheduledWeekdays.add(DayOfWeek.TUESDAY);
        this.scheduledWeekdays.add(DayOfWeek.WEDNESDAY);
        this.scheduledWeekdays.add(DayOfWeek.THURSDAY);
        this.scheduledWeekdays.add(DayOfWeek.FRIDAY);
        this.scheduledWeekdays.add(DayOfWeek.SATURDAY);
        this.scheduledWeekdays.add(DayOfWeek.SUNDAY);
    }

}
