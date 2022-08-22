package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@ComponentScan(basePackages = /*"com.example"*/{"com.example.rest",
        "com.example.api",
        "com.example.domain",
        "com.example.core"})
@EnableJpaRepositories(basePackages = "com.example.domain.repository")
@EntityScan(basePackages = "com.example.domain.entity")
@EnableSwagger2
@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
