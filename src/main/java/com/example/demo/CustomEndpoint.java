package com.example.demo;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom-endpoint")
public class CustomEndpoint {

    @ReadOperation
    public String custom() {
        return "Test";

    }

    @ReadOperation
    public String customEndPointByName(@Selector String name) {
        return name;
    }


}