package com.cognizant.ormlearn;

import com.cognizant.ormlearn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(Application.class, args);

		CountryService service =
				context.getBean(CountryService.class);

		System.out.println(service.getAllCountries());
	}
}