package com.example.ems.controller;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeEmailView;
import com.example.ems.projection.EmployeeSummary;
import com.example.ems.service.EmployeeProjectionService;
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
    private final EmployeeProjectionService employeeProjectionService;

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

    @GetMapping("/projections/summaries")
    public List<EmployeeSummary> getSummaries() {
        return employeeProjectionService.getAllSummaries();
    }

    @GetMapping("/projections/dtos")
    public List<EmployeeDto> getDtos() {
        return employeeProjectionService.getAllDtos();
    }

    @GetMapping("/projections/email-views")
    public List<EmployeeEmailView> getEmailViews(@RequestParam(defaultValue = "") String name) {
        return employeeProjectionService.searchEmailViews(name);
    }
}
