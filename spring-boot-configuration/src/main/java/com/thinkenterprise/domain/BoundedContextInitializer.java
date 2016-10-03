package com.thinkenterprise.domain;

import com.thinkenterprise.domain.aircraft.Aircraft;
import com.thinkenterprise.repository.AircraftRepository;
import com.thinkenterprise.domain.employee.CabinAttendant;
import com.thinkenterprise.domain.employee.Employee;
import com.thinkenterprise.repository.EmployeeRepository;
import com.thinkenterprise.domain.employee.Pilot;
import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BoundedContextInitializer {

    @Value("${route.count}")
    private short routeCount;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Bean
    public List<Aircraft> aircraftList() {
        List<Aircraft> result = new ArrayList<>();
        result.add(new Aircraft("B764", "D-BILA"));
        result.add(new Aircraft("A320", "D-AIPA"));
        return result;
    }

    @Bean
    public List<Employee> employeeList() {
        List<Employee> result = new ArrayList<>();

        Employee employee = new Employee("P234238", "Fred", "Flieger");
        Pilot pilot = new Pilot("RF775566734", new String[]{"A320", "B764"});
        employee.setRole(pilot);
        result.add(employee);

        employee = new Employee("P234234", "Tom", "Purser");
        CabinAttendant cabinAttendant = new CabinAttendant(1);
        employee.setRole(cabinAttendant);
        result.add(employee);

        employee = new Employee("S77667", "Sarah", "Stewardess");
        cabinAttendant = new CabinAttendant(2);
        employee.setRole(cabinAttendant);
        result.add(employee);

        return result;
    }

    @Bean
    public List<Route> routesList() {
        List<Route> result = new ArrayList<>();
        for (short i = 0; i < routeCount; i++) {

            // München-Houston LH7902
            //
            Route route = new Route("LH7902", "MUC", "IAH");
            route.addScheduledDaily();
            route.setDepartureTime(LocalTime.of(9, 30));
            route.setArrivalTime(LocalTime.of(14, 0));

            // Flug am 23.09.2015
            Flight flight = new Flight(120.45, LocalDate.of(2015, 9, 23));
            Aircraft aircraft = this.aircraftRepository.findByRegistration("D-BILA");
            route.setAircraft(aircraft);
            Employee pilot = this.employeeRepository.findByStaffNumber("P234238");
            flight.addEmployee(pilot);
            Employee purser = this.employeeRepository.findByStaffNumber("P234234");
            flight.addEmployee(purser);
            flight.setRoute(route);
            route.addFlight(flight);

            // Flug am 24.09.2015
            flight = new Flight(111.45, LocalDate.of(2015, 9, 24));
            aircraft = this.aircraftRepository.findByRegistration("D-BILA");
            route.setAircraft(aircraft);
            flight.setRoute(route);
            route.addFlight(flight);

            result.add(route);

            // München-Ibiza LH1602
            //
            route = new Route("LH1602", "MUC", "IBZ");
            route.addScheduledWeekday(DayOfWeek.SATURDAY);
            route.setDepartureTime(LocalTime.of(8, 50));
            route.setArrivalTime(LocalTime.of(11, 15));

            flight = new Flight(120.45, LocalDate.of(2015, 9, 19));
            aircraft = this.aircraftRepository.findByRegistration("D-AIPA");
            route.setAircraft(aircraft);
            route.addFlight(flight);

            result.add(route);

            // München-Ibiza LH1838
            //
            route = new Route("LH1838", "MUC", "IBZ");
            route.addScheduledWeekday(DayOfWeek.MONDAY);
            route.addScheduledWeekday(DayOfWeek.THURSDAY);
            route.addScheduledWeekday(DayOfWeek.SATURDAY);
            route.setDepartureTime(LocalTime.of(12, 25));
            route.setArrivalTime(LocalTime.of(14, 50));

            flight = new Flight(120.45, LocalDate.of(2015, 9, 19));
            aircraft = this.aircraftRepository.findByRegistration("D-AIPA");
            route.setAircraft(aircraft);
            route.addFlight(flight);

            result.add(route);

            // München-New York LH401
            //
            route = new Route("LH401", "FRA", "NYC");
            route.addScheduledDaily();
            route.setDepartureTime(LocalTime.of(15, 55));
            route.setArrivalTime(LocalTime.of(5, 30));

            flight = new Flight(120.45, LocalDate.of(2015, 9, 30));
            aircraft = this.aircraftRepository.findByRegistration("D-AIPA");
            route.setAircraft(aircraft);
            route.addFlight(flight);

            result.add(route);
        }
        return result;
    }
}
