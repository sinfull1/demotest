package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test", "gcp"})
public class ApplicationTests {

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    WebTestClient webTestClient;


    @Test
    public void test() {
        String myResource = this.webTestClient
                .get()
                .uri("/func")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectBody(String.class)
                .returnResult().getResponseBody();

        System.out.println(myResource);

    }

}




