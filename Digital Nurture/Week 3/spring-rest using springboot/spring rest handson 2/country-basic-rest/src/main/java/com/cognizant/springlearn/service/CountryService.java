package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

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

    public Country getCountry(String code) {
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        return null;
    }
}
