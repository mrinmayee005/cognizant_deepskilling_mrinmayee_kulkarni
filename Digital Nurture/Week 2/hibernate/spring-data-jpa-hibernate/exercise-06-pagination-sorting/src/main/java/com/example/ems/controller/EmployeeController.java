package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeSearchService;
import com.example.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeSearchService employeeSearchService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employee));
    }

    @GetMapping
    public Page<Employee> getAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return employeeSearchService.findAllPaged(buildPageable(page, size, sort));
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

    @GetMapping("/search")
    public Page<Employee> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String departmentName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {

        Pageable pageable = buildPageable(page, size, sort);

        if (name != null && !name.isBlank()) {
            return employeeSearchService.searchByName(name, pageable);
        }
        if (departmentName != null && !departmentName.isBlank()) {
            return employeeSearchService.findByDepartment(departmentName, pageable);
        }
        return employeeSearchService.findAllPaged(pageable);
    }

    private Pageable buildPageable(int page, int size, String[] sort) {
        List<Sort.Order> orders = Arrays.stream(sort)
                .map(s -> {
                    String[] parts = s.split(",");
                    Sort.Direction direction = parts.length > 1 && "desc".equalsIgnoreCase(parts[1])
                            ? Sort.Direction.DESC
                            : Sort.Direction.ASC;
                    return new Sort.Order(direction, parts[0]);
                })
                .toList();
        return PageRequest.of(page, size, Sort.by(orders));
    }
}
