package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    public CountryController() {
        logger.info("CountryController constructor called");
    }

    @RequestMapping("/country")
    public Country getCountryIndia() {
        logger.info("START - getCountryIndia()");
        Country country = countryService.getCountryIndia();
        logger.info("END - getCountryIndia()");
        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        logger.info("START - getAllCountries()");
        List<Country> countries = countryService.getAllCountries();
        logger.info("END - getAllCountries()");
        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        logger.info("START - getCountry()");
        Country country = countryService.getCountry(code);
        logger.info("END - getCountry()");
        return country;
    }
}
