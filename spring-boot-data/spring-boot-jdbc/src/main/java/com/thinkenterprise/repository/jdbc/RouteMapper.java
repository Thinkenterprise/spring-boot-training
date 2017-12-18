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
 
 * @author Michael Schaefer
 */

package com.thinkenterprise.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thinkenterprise.domain.route.Route;

public class RouteMapper implements RowMapper<Route>{

	@Override
	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Route route = new Route();
		
		route.setId(rs.getInt("id"));
		route.setDeparture(rs.getString("departure"));
		route.setDestination(rs.getString("destination"));
		route.setFlightNumber(rs.getString("flightNumber"));
		
		return route;
		
	}
	
}
