package com.cognizant.ormlearn;

import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final SkillRepository skillRepository;

    public OrmLearnApplication(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               SkillRepository skillRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.skillRepository = skillRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.debug("Employees: {}", employeeRepository.findAll());
        LOGGER.debug("Departments: {}", departmentRepository.findAll());
        LOGGER.debug("Skills: {}", skillRepository.findAll());
    }
}

