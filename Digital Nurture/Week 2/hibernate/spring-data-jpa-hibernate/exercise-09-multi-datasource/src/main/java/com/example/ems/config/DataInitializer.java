package com.example.ems.config;

import com.example.ems.entity.Department;
import com.example.ems.entity.Employee;
import com.example.ems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final DepartmentRepository departmentRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            if (departmentRepository.count() == 0) {
                Department engineering = new Department();
                engineering.setName("Engineering");

                Employee alice = new Employee();
                alice.setName("Alice Johnson");
                alice.setEmail("alice@example.com");
                engineering.addEmployee(alice);

                departmentRepository.save(engineering);
            }
        };
    }
}
