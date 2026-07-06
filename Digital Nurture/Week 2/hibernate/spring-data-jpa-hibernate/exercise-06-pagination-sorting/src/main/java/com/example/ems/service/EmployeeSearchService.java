package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeSearchService {

    private final EmployeeRepository employeeRepository;

    public Page<Employee> searchByName(String name, Pageable pageable) {
        return employeeRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Page<Employee> findByDepartment(String departmentName, Pageable pageable) {
        return employeeRepository.findByDepartmentName(departmentName, pageable);
    }

    public Page<Employee> findAllPaged(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
