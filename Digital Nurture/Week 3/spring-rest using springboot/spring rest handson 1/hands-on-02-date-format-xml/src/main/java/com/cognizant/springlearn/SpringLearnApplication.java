package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) throws ParseException {
        LOGGER.info("START - SpringLearnApplication main()");
        SpringApplication.run(SpringLearnApplication.class, args);
        SpringLearnApplication app = new SpringLearnApplication();
        app.displayDate();
        LOGGER.info("END - SpringLearnApplication main()");
    }

    public void displayDate() throws ParseException {
        LOGGER.info("START - displayDate()");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        Date date = format.parse("31/12/2018");
        System.out.println(date);
        LOGGER.info("END - displayDate()");
    }
}
