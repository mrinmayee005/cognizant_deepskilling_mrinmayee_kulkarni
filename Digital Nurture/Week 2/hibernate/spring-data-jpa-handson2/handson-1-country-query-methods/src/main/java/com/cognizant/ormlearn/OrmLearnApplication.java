package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private final CountryRepository countryRepository;

    public OrmLearnApplication(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testSearchCountriesContainingText();
        testSearchCountriesContainingTextSorted();
        testSearchCountriesStartingWithAlphabet();
    }

    private void testSearchCountriesContainingText() {
        LOGGER.info("Countries containing 'ou'");
        printCountries(countryRepository.findByNameContainingIgnoreCase("ou"));
    }

    private void testSearchCountriesContainingTextSorted() {
        LOGGER.info("Countries containing 'ou' sorted by name");
        printCountries(countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou"));
    }

    private void testSearchCountriesStartingWithAlphabet() {
        LOGGER.info("Countries starting with 'Z'");
        printCountries(countryRepository.findByNameStartingWithIgnoreCase("Z"));
    }

    private void printCountries(List<Country> countries) {
        countries.forEach(country -> LOGGER.debug("{} {}", country.getCode(), country.getName()));
    }
}

