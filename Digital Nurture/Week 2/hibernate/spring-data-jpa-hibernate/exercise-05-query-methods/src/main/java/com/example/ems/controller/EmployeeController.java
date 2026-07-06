package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeQueryService;
import com.example.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeQueryService employeeQueryService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employee));
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/domain")
    public List<Employee> searchByEmailDomain(@RequestParam String domain) {
        return employeeQueryService.findByEmailDomain(domain);
    }

    @GetMapping("/search/named")
    public List<Employee> searchByDepartmentNamed(@RequestParam String departmentName) {
        return employeeQueryService.findByDepartmentNameNamed(departmentName);
    }

    @GetMapping("/search/custom")
    public List<Employee> searchByDepartmentAndName(
            @RequestParam String departmentName,
            @RequestParam String namePart) {
        return employeeQueryService.findByDepartmentAndNamePart(departmentName, namePart);
    }

    @GetMapping("/count-by-department/{departmentId}")
    public long countByDepartment(@PathVariable Long departmentId) {
        return employeeQueryService.countByDepartment(departmentId);
    }
}
