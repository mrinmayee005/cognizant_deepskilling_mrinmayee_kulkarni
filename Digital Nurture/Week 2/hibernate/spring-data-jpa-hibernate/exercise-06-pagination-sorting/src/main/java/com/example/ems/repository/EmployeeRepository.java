package com.example.ems.repository;

import com.example.ems.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByNameContainingIgnoreCase(String name);

    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    Page<Employee> findAll(Pageable pageable);
}
