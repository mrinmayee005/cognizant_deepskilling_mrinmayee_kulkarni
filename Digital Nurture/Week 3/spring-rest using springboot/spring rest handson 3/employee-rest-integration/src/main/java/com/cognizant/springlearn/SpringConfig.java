package com.cognizant.springlearn;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@Configuration
@ImportResource("classpath:employee.xml")
public class SpringConfig {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Bean
    public void initializeData(List<Object> employeeList, List<Object> departmentList) {
        employeeDao.setEmployeeList(employeeList);
        departmentDao.setDepartmentList(departmentList);
    }
}
