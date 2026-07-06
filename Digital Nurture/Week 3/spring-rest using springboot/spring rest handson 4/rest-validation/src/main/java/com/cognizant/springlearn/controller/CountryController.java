package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/countries")
@Validated
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    public CountryController() {
        logger.info("CountryController constructor called");
    }

    @GetMapping
    public List<Country> getAllCountries() {
        logger.info("START - getAllCountries()");
        List<Country> countries = countryService.getAllCountries();
        logger.info("END - getAllCountries()");
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        logger.info("START - getCountry()");
        Country country = countryService.getCountry(code);
        logger.info("END - getCountry()");
        return country;
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        logger.info("START - addCountry()");
        logger.info("Country: " + country);
        Country addedCountry = countryService.addCountry(country);
        logger.info("END - addCountry()");
        return addedCountry;
    }

    @PutMapping
    public Country updateCountry(@RequestBody @Valid Country country) throws CountryNotFoundException {
        logger.info("START - updateCountry()");
        Country updatedCountry = countryService.updateCountry(country);
        logger.info("END - updateCountry()");
        return updatedCountry;
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) throws CountryNotFoundException {
        logger.info("START - deleteCountry()");
        countryService.deleteCountry(code);
        logger.info("END - deleteCountry()");
    }
}
