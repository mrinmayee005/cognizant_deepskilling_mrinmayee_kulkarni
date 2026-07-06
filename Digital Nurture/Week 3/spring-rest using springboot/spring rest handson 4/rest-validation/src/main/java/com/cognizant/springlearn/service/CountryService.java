package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
    
    private List<Country> countries;

    public CountryService() {
        countries = new ArrayList<>();
        countries.add(new Country("IN", "India"));
        countries.add(new Country("US", "United States"));
        countries.add(new Country("JP", "Japan"));
        countries.add(new Country("DE", "Germany"));
    }

    public Country getCountryIndia() {
        return new Country("IN", "India");
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        throw new CountryNotFoundException("Country not found");
    }

    public Country addCountry(Country country) {
        countries.add(country);
        return country;
    }

    public Country updateCountry(Country country) throws CountryNotFoundException {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equalsIgnoreCase(country.getCode())) {
                countries.set(i, country);
                return country;
            }
        }
        throw new CountryNotFoundException("Country not found");
    }

    public void deleteCountry(String code) throws CountryNotFoundException {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equalsIgnoreCase(code)) {
                countries.remove(i);
                return;
            }
        }
        throw new CountryNotFoundException("Country not found");
    }
}
