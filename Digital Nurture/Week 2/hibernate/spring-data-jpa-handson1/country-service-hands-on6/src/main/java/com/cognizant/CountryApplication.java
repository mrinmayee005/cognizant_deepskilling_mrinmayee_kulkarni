package com.cognizant;

import com.cognizant.model.Country;
import com.cognizant.service.CountryService;
import com.cognizant.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryApplication.class);

    @Autowired
    private CountryService service;

    public static void main(String[] args) {
        SpringApplication.run(CountryApplication.class, args);
    }

    @PostConstruct
    public void test() {
        LOGGER.info("Start");

        try {
            Country c = service.findCountryByCode("IN");
            LOGGER.debug("Country: {}", c);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        LOGGER.info("End");
    }
}