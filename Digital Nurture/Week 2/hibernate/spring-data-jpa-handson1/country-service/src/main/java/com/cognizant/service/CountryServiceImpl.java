package com.cognizant.service;

import com.cognizant.entity.Country;
import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country getByCode(String code) {
        return repository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country not found: " + code));
    }

    @Override
    public Country addCountry(Country country) {
        return repository.save(country);
    }

    @Override
    public Country updateCountry(String code, Country country) {
        Country existing = getByCode(code);
        existing.setName(country.getName());
        return repository.save(existing);
    }

    @Override
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    @Override
    public List<Country> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}