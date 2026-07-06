package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeQueryService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findByEmailDomain(String domain) {
        return employeeRepository.findByEmailDomain(domain);
    }

    public List<Employee> findByDepartmentAndNamePart(String deptName, String namePart) {
        return employeeRepository.findByDepartmentAndNamePart(deptName, namePart);
    }

    public List<Employee> findByDepartmentNameNamed(String name) {
        return employeeRepository.findByDepartmentNameNamed(name);
    }

    public long countByDepartment(Long departmentId) {
        return employeeRepository.countByDepartmentNamed(departmentId);
    }
}
