package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class DemoApplicationTests {

	@Autowired
	ResourceRepository repository;

	@Test
	public void testRepository()
	{
		MyResource emp = new MyResource();

		emp.setName("sid");

		repository.save(emp);

		List<MyResource> resource = repository.findAll();
		System.out.print(resource);

		Assert.assertNotNull(emp.getId());
	}
}
