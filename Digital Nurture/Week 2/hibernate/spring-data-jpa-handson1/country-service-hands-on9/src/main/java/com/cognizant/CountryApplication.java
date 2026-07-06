package com.cognizant;

import com.cognizant.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountryApplication {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(CountryApplication.class, args);

        CountryApplication app = context.getBean(CountryApplication.class);
        app.testDeleteCountry();
    }

    private void testDeleteCountry() {
        System.out.println("Start Delete");

        countryService.deleteCountry("ZZ"); // existing code

        System.out.println("Deleted Successfully");
        System.out.println("End Delete");
    }
}