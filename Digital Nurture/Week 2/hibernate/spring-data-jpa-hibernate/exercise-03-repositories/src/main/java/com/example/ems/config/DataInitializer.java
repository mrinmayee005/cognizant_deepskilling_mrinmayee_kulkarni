package com.example.ems.config;

import com.example.ems.entity.Department;
import com.example.ems.entity.Employee;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            Department engineering = new Department();
            engineering.setName("Engineering");

            Employee alice = new Employee();
            alice.setName("Alice Johnson");
            alice.setEmail("alice@example.com");
            engineering.addEmployee(alice);

            departmentRepository.save(engineering);

            System.out.println("Departments: " + departmentRepository.count());
            System.out.println("Employees: " + employeeRepository.count());
            employeeRepository.findByEmail("alice@example.com")
                    .ifPresent(e -> System.out.println("Found employee: " + e.getName()));
        };
    }
}
