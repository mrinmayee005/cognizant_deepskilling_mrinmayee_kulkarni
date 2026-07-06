package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        logger.info("EmployeeController constructor called");
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        logger.info("START - getAllEmployees()");
        List<Employee> employees = employeeService.getAllEmployees();
        logger.info("END - getAllEmployees()");
        return employees;
    }
}
