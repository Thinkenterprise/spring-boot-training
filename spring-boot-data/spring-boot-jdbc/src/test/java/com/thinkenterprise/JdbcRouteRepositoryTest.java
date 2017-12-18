package com.thinkenterprise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thinkenterprise.repository.jdbc.JdbcRouteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcRouteRepositoryTest {

	@Autowired
	private JdbcRouteRepository jdbcRouteRepository;
	
	@Test
	public void testGetAll() {
		Assert.assertTrue(jdbcRouteRepository.findAll().size()==3);
	}
	
}
