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

package com.thinkenterprise.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.Route;

@Component
public class BoundedContextInitializer {

    @Autowired
    //PlatformTransactionManager txManager;

   /*Ü
    @PostConstruct
    public void init() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("InitTx");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = txManager.getTransaction(def);
        try {
            initRoutes();
        } catch (Exception ex) {
            txManager.rollback(status);
            throw ex;
        }
        txManager.commit(status);
    }
*/
    private void initRoutes() {

        // München-Houston LH7902
        //
        Route route = new Route("LH7902", "MUC", "IAH");
        route.addScheduledDaily();
        route.setDepartureTime(LocalTime.of(9, 30));
        route.setArrivalTime(LocalTime.of(14, 00));

        // Flug am 23.09.2015
        Flight flight = new Flight(120.45, LocalDate.of(2015, 9, 23));
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
        route.addFlight(flight);

      
        // München-New York LH401
        //
        route = new Route("LH401", "FRA", "NYC");
        route.addScheduledDaily();
        route.setDepartureTime(LocalTime.of(15, 55));
        route.setArrivalTime(LocalTime.of(5, 30));

        flight = new Flight(120.45, LocalDate.of(2015, 9, 30));
        route.addFlight(flight);

      
    }
}
