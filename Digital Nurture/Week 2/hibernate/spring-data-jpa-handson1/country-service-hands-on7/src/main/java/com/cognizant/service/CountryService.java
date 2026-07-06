package com.cognizant.service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // 🔹 ADD COUNTRY
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // 🔹 FIND COUNTRY
    @Transactional
    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }
}