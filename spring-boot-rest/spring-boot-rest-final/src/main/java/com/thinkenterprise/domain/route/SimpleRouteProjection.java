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

import org.springframework.data.rest.core.config.Projection;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Projection(name = "SimpleRoute", types = Route.class)
interface SimpleRouteProjection {
    String getDeparture();

    String getDestination();

    String getFlightNumber();

    Double getTotal();

    LocalTime getDepartureTime();

    LocalTime getArrivalTime();

    Set<DayOfWeek> getScheduledWeekdays();

    String getAircraft();
}
