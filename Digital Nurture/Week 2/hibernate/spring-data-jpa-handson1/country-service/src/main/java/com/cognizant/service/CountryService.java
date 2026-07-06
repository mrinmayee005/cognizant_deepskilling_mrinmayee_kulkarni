package com.cognizant.service;

import com.cognizant.entity.Country;
import java.util.List;

public interface CountryService {
    Country getByCode(String code);
    Country addCountry(Country country);
    Country updateCountry(String code, Country country);
    void deleteCountry(String code);
    List<Country> searchByName(String name);
}