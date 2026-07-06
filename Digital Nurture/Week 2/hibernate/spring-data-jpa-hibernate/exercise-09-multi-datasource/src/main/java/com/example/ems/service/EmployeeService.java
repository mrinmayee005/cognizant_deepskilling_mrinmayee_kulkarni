package com.example.ems.service;

import com.example.ems.audit.service.AuditLogService;
import com.example.ems.entity.Department;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional("primaryTransactionManager")
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final AuditLogService auditLogService;

    public Employee create(Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department department = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Department not found with id: " + employee.getDepartment().getId()));
            employee.setDepartment(department);
        }
        Employee saved = employeeRepository.save(employee);
        auditLogService.log("Employee", "CREATE", saved.getId(), "Created employee: " + saved.getName());
        return saved;
    }

    @Transactional(value = "primaryTransactionManager", readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional(value = "primaryTransactionManager", readOnly = true)
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee update(Long id, Employee updated) {
        Employee existing = findById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        if (updated.getDepartment() != null && updated.getDepartment().getId() != null) {
            Department department = departmentRepository.findById(updated.getDepartment().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Department not found with id: " + updated.getDepartment().getId()));
            existing.setDepartment(department);
        }
        Employee saved = employeeRepository.save(existing);
        auditLogService.log("Employee", "UPDATE", saved.getId(), "Updated employee: " + saved.getName());
        return saved;
    }

    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        auditLogService.log("Employee", "DELETE", id, "Deleted employee id: " + id);
    }
}
