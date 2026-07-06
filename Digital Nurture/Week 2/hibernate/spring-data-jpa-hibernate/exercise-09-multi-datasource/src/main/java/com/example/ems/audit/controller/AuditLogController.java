package com.example.ems.audit.controller;

import com.example.ems.audit.entity.AuditLog;
import com.example.ems.audit.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogService auditLogService;

    @GetMapping
    public List<AuditLog> getAll() {
        return auditLogService.findAll();
    }

    @GetMapping("/entity/{entityType}")
    public List<AuditLog> getByEntityType(@PathVariable String entityType) {
        return auditLogService.findByEntityType(entityType);
    }

    @PostMapping
    public AuditLog create(@RequestBody AuditLog auditLog) {
        return auditLogService.log(
                auditLog.getEntityType(),
                auditLog.getAction(),
                auditLog.getEntityId(),
                auditLog.getDetails());
    }
}
