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

package com.thinkenterprise.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thinkenterprise.domain.route.Route;

@Repository
public class JpaRouteRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Route> findAll() {
		TypedQuery<Route> query = entityManager.   createQuery("select r from Route r",Route.class);
		return query.getResultList();
	}
	
	public Route find(Integer id) {
		return entityManager.find(Route.class, id);
	}
	
	public Route save(Route route) {
		 entityManager.persist(route);
		 return route;
	}
	
}
