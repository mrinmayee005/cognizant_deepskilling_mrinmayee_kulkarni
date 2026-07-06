package com.cognizant.service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void updateCountry(String code, String name) {

        Optional<Country> result = countryRepository.findById(code);

        if (result.isPresent()) {
            Country country = result.get();

            // update
            country.setName(name);

            // save
            countryRepository.save(country);

            System.out.println("Updated Successfully");
        } else {
            System.out.println("Country Not Found");
        }
    }
}