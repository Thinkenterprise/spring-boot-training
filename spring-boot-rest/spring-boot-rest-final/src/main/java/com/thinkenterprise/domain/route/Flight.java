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

import com.thinkenterprise.domain.core.AbstractEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Flight extends AbstractEntity {

    private double price;

    private LocalDate date;

    @ElementCollection
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
