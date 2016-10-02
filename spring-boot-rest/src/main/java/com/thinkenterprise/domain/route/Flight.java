package com.thinkenterprise.domain.route;

import com.thinkenterprise.domain.core.AbstractEntity;
import com.thinkenterprise.domain.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Flight extends AbstractEntity {

    private double price;

    private LocalDate date;

    @ManyToOne
    private Route route;

    @OneToMany
    private Set<Employee> employees = new HashSet<>();

    public Flight() {
        super();
    }

    public Flight(double price, LocalDate date) {
        super();
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
