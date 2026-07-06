package com.cognizant.service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import com.cognizant.service.exception.CountryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> result = repository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found: " + countryCode);
        }

        return result.get();
    }
}