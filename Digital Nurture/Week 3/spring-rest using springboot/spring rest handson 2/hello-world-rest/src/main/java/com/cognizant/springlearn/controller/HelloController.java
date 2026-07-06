package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    public HelloController() {
        logger.info("HelloController constructor called");
    }

    @GetMapping("/hello")
    public String sayHello() {
        logger.info("START - sayHello()");
        String response = "Hello World!!";
        logger.info("END - sayHello()");
        return response;
    }
}
