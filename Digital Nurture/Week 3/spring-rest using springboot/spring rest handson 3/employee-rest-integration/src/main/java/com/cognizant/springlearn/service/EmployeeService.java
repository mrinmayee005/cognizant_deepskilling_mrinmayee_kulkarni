package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeService() {
        logger.info("EmployeeService constructor called");
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        logger.info("START - getAllEmployees()");
        List<Employee> employees = employeeDao.getAllEmployees();
        logger.info("END - getAllEmployees()");
        return employees;
    }
}
