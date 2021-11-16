package com.example.demo;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    WebTestClient webTestClient;




    @Test
    public void test()
    {
       MyResource[] myResource= this.webTestClient
                .get()
                .uri("/resource")
                .header(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                        .expectBody(MyResource[].class)
                                .returnResult().getResponseBody();

         System.out.println(myResource[0].toString()) ;

    }

    }




