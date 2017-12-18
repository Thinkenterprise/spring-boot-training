package com.thinkenterprise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thinkenterprise.repository.jpa.JpaRouteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaRouteRepositoryTest {

	@Autowired
	private JpaRouteRepository jdbcRouteRepository;
	
	@Test
	public void testGetAll() {
		Assert.assertTrue(jdbcRouteRepository.findAll().size()==3);
	}
	
}
