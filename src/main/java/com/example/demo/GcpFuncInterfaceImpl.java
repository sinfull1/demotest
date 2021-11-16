package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("gcp")
@Component
public class GcpFuncInterfaceImpl implements FuncInterface {

    @Value("${my.cloud.property}")
    private String property;

    @Value("${my.deploy.env}")
    private String env;

    @Override
    public String getName() {
        return property + " " + env;
    }
}
