package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
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

    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
        logger.info("START - updateEmployee()");
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId() == employee.getId()) {
                EMPLOYEE_LIST.set(i, employee);
                logger.info("END - updateEmployee()");
                return employee;
            }
        }
        logger.info("END - updateEmployee()");
        throw new EmployeeNotFoundException("Employee not found");
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        logger.info("START - deleteEmployee()");
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId() == id) {
                EMPLOYEE_LIST.remove(i);
                logger.info("END - deleteEmployee()");
                return;
            }
        }
        logger.info("END - deleteEmployee()");
        throw new EmployeeNotFoundException("Employee not found");
    }
}
