package com.example.ems.service;

import com.example.ems.audit.service.AuditLogService;
import com.example.ems.entity.Department;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional("primaryTransactionManager")
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final AuditLogService auditLogService;

    public Department create(Department department) {
        Department saved = departmentRepository.save(department);
        auditLogService.log("Department", "CREATE", saved.getId(), "Created department: " + saved.getName());
        return saved;
    }

    @Transactional(value = "primaryTransactionManager", readOnly = true)
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Transactional(value = "primaryTransactionManager", readOnly = true)
    public Department findById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    public Department update(Long id, Department updated) {
        Department existing = findById(id);
        existing.setName(updated.getName());
        Department saved = departmentRepository.save(existing);
        auditLogService.log("Department", "UPDATE", saved.getId(), "Updated department: " + saved.getName());
        return saved;
    }

    public void delete(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }
        departmentRepository.deleteById(id);
        auditLogService.log("Department", "DELETE", id, "Deleted department id: " + id);
    }
}
