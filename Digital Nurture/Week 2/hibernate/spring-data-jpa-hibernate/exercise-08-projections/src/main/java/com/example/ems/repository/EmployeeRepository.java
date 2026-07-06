package com.example.ems.repository;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeEmailView;
import com.example.ems.projection.EmployeeSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartmentName(String departmentName);

    @Query("""
            SELECT e.id AS id, e.name AS name, e.email AS email, d.name AS departmentName
            FROM Employee e JOIN e.department d
            """)
    List<EmployeeSummary> findAllSummaries();

    @Query("SELECT new com.example.ems.dto.EmployeeDto(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeDto> findAllDtos();

    List<EmployeeEmailView> findByNameContainingIgnoreCase(String namePart, Class<EmployeeEmailView> type);
}
