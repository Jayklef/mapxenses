package com.jayklef.mapxenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MapxensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapxensesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
}
