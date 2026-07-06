package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repo;

    @Transactional
    public List<Country> getAllCountries() {
        return repo.findAll();
    }
}