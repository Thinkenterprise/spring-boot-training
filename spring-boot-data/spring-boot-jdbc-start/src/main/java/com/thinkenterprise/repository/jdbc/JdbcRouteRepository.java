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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.thinkenterprise.domain.route.Route;

@Repository
public class JdbcRouteRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Route> findAll() {
		return jdbcTemplate.query("select * from route", new RouteMapper());	
	}
	
	public Route find(Integer id) {
		return jdbcTemplate.queryForObject("select * from route where id=?", new Object[] {id}, new RouteMapper());
	}
	
	public Route save(Route route) {
		
		final String sql = "insert into route(flightNumber, departure, destination) values(?,?,?)";
		
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {           

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, route.getFlightNumber());
                    ps.setString(2, route.getDeparture());
                    ps.setString(3, route.getDestination());
                   
                    return ps;
                }
            }, holder);

		int newRouteId = holder.getKey().intValue();
		route.setId(newRouteId);		
		return route;
		
	}

}
