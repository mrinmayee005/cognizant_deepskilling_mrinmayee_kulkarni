package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeBatchService;
import com.example.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeBatchService employeeBatchService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employee));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Employee>> bulkCreate(@RequestBody List<Employee> employees) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeBatchService.bulkCreate(employees));
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

    @GetMapping("/hibernate/statistics")
    public Map<String, Object> getHibernateStatistics() {
        return employeeBatchService.getHibernateStatistics();
    }
}
