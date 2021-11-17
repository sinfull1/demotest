package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class JpaTests {

    @Autowired
    ResourceRepository repository;

    @Test
    public void testRepository() {
        MyResource emp = new MyResource();

        emp.setName("sid");

        repository.save(emp);

        List<MyResource> resource = repository.findAll();
        System.out.print(resource);

        Assert.assertNotNull(emp.getId());
    }
}
