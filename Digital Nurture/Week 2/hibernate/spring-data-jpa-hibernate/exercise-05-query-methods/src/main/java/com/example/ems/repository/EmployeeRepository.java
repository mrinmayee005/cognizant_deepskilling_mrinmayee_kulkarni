package com.example.ems.repository;

import com.example.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByDepartmentNameIgnoreCase(String name);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE CONCAT('%', :domain, '%')")
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = :deptName AND e.name LIKE CONCAT('%', :namePart, '%')")
    List<Employee> findByDepartmentAndNamePart(@Param("deptName") String deptName,
                                               @Param("namePart") String namePart);

    @Query(value = "SELECT * FROM employees WHERE department_id = :deptId", nativeQuery = true)
    List<Employee> findByDepartmentIdNative(@Param("deptId") Long deptId);

    @Query(name = "Employee.findByDepartmentNameNamed")
    List<Employee> findByDepartmentNameNamed(@Param("name") String name);

    @Query(name = "Employee.countByDepartment")
    long countByDepartmentNamed(@Param("departmentId") Long departmentId);
}
