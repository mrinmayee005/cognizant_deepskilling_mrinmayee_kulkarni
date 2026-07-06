package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        logger.info("EmployeeController constructor called");
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("START - getAllEmployees()");
        List<Employee> employees = employeeService.getAllEmployees();
        logger.info("END - getAllEmployees()");
        return employees;
    }

    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        logger.info("START - updateEmployee()");
        employeeService.updateEmployee(employee);
        logger.info("END - updateEmployee()");
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        logger.info("START - deleteEmployee()");
        employeeService.deleteEmployee(id);
        logger.info("END - deleteEmployee()");
    }
}
