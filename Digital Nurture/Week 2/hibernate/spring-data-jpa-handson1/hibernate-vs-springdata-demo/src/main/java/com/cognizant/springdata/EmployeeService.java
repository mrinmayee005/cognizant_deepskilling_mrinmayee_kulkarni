package com.cognizant.springdata;

import com.cognizant.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Transactional
    public void addEmployee() {

        Employee emp = new Employee();
        emp.setName("Spring User");
        emp.setSalary(60000);

        repo.save(emp);

        System.out.println("Spring Data Insert Done");
    }
}