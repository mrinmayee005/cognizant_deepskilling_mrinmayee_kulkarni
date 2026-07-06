package com.example.ems.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(
                name = "Employee.findByDepartmentNameNamed",
                query = "SELECT e FROM Employee e WHERE e.department.name = :name"
        ),
        @NamedQuery(
                name = "Employee.countByDepartment",
                query = "SELECT COUNT(e) FROM Employee e WHERE e.department.id = :departmentId"
        )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "department")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
