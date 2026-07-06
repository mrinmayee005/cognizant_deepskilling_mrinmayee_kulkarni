package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
    
    private static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        logger.info("EmployeeDao constructor called");
    }

    public void setEmployeeList(List<Employee> employeeList) {
        EMPLOYEE_LIST = employeeList;
    }

    public List<Employee> getAllEmployees() {
        logger.info("START - getAllEmployees()");
        logger.info("END - getAllEmployees()");
        return EMPLOYEE_LIST;
    }
}
