package com.thinkenterprise.domain;

import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.Route;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Spring Projections Samples Design and Development by msg Applied Technology
 * Research Copyright (c) 2015 msg systems ag (http://www.msg-systems.com/) All
 * Rights Reserved.
 *
 * @author Michael Schäfer, Achim Müller
 */

@Component
public class BoundedContextInitializer {

    @PostConstruct
    public void init() {
        initRoutes();
    }

    private void initRoutes() {

        // München-Houston LH7902
        //
        Route route = new Route("LH7902", "MUC", "IAH");
        route.addScheduledDaily();
        route.setDepartureTime(LocalTime.of(9, 30));
        route.setArrivalTime(LocalTime.of(14, 00));

        // Flug am 23.09.2015
        Flight flight = new Flight(120.45, LocalDate.of(2015, 9, 23));
        flight.addEmployee("Fred");
        flight.addEmployee("Sarah");
        route.addFlight(flight);

        // Flug am 24.09.2015
        flight = new Flight(111.45, LocalDate.of(2015, 9, 24));
        route.addFlight(flight);


        // München-Ibiza LH1602
        //
        route = new Route("LH1602", "MUC", "IBZ");
        route.addScheduledWeekday(DayOfWeek.SATURDAY);
        route.setDepartureTime(LocalTime.of(8, 50));
        route.setArrivalTime(LocalTime.of(11, 15));

        flight = new Flight(120.45, LocalDate.of(2015, 9, 19));
        route.addFlight(flight);

        // München-Ibiza LH1838
        //
        route = new Route("LH1838", "MUC", "IBZ");
        route.addScheduledWeekday(DayOfWeek.MONDAY);
        route.addScheduledWeekday(DayOfWeek.THURSDAY);
        route.addScheduledWeekday(DayOfWeek.SATURDAY);
        route.setDepartureTime(LocalTime.of(12, 25));
        route.setArrivalTime(LocalTime.of(14, 50));

        flight = new Flight(120.45, LocalDate.of(2015, 9, 19));
        route.setAircraft("D-AIPA");
        route.addFlight(flight);

        // München-New York LH401
        //
        route = new Route("LH401", "FRA", "NYC");
        route.addScheduledDaily();
        route.setDepartureTime(LocalTime.of(15, 55));
        route.setArrivalTime(LocalTime.of(5, 30));

        flight = new Flight(120.45, LocalDate.of(2015, 9, 30));
        route.setAircraft("D-AIPA");
        route.addFlight(flight);
    }
}
