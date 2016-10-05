package com.thinkenterprise.domain.route;

import com.thinkenterprise.domain.core.AbstractEntity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Flight extends AbstractEntity {

    private double price;

    private LocalDate date;

    private Set<String> employees = new HashSet<>();

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

    public Set<String> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<String> employees) {
        this.employees = employees;
    }

    public void addEmployee(String e) {
        this.employees.add(e);
    }

}
