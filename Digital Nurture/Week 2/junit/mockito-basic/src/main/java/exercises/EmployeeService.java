package exercises;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Employee not found: " + id);
        }
        repository.deleteById(id);
    }

    public Employee updateSalary(Long id, double newSalary) {
        Employee employee = getEmployeeById(id);
        employee.setSalary(newSalary);
        return repository.save(employee);
    }
}
