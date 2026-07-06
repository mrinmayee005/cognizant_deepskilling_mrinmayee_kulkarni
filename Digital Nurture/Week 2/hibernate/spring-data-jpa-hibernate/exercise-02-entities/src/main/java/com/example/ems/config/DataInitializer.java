package com.example.ems.config;

import com.example.ems.entity.Department;
import com.example.ems.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DataInitializer {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    CommandLineRunner initData() {
        return args -> persistSampleData();
    }

    @Transactional
    void persistSampleData() {
        Department engineering = new Department();
        engineering.setName("Engineering");

        Employee alice = new Employee();
        alice.setName("Alice Johnson");
        alice.setEmail("alice@example.com");
        engineering.addEmployee(alice);

        Employee bob = new Employee();
        bob.setName("Bob Smith");
        bob.setEmail("bob@example.com");
        engineering.addEmployee(bob);

        entityManager.persist(engineering);
        System.out.println("Sample department and employees persisted successfully.");
    }
}
