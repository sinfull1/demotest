package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CustomConfiguration {


    @Bean
    @Profile("prod")
    public FuncInterface2 getProdLocation(){
        return new ProductionFuncInterface2Impl();
    }


    @Bean
    @Profile("dev")
    public FuncInterface2 getDevLocation(){
        return new DevFuncInterface2Impl();
    }

}
