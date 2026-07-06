package com.cognizant;

import com.cognizant.model.Country;
import com.cognizant.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountryApplication {

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(CountryApplication.class, args);

        countryService = context.getBean(CountryService.class);

        testAddCountry();
    }

    private static void testAddCountry() {

        System.out.println("Start Add Country");

        Country country = new Country();
        country.setCode("ZZ");
        country.setName("New Country");

        countryService.addCountry(country);

        Country result = countryService.findCountryByCode("ZZ");

        System.out.println("Added Country: " + result);

        System.out.println("End Add Country");
    }
}