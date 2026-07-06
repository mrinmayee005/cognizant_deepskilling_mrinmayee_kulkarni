package com.cognizant.service;

import com.cognizant.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
}