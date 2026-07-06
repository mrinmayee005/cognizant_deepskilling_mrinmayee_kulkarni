package com.cognizant;

import com.cognizant.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CountryApplication {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(CountryApplication.class, args);
    }

    @PostConstruct
    public void testUpdate() {
        System.out.println("Start Update");

        countryService.updateCountry("IN", "India New");

        System.out.println("End Update");
    }
}