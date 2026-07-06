package com.example.ems.audit.service;

import com.example.ems.audit.entity.AuditLog;
import com.example.ems.audit.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional("secondaryTransactionManager")
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLog log(String entityType, String action, Long entityId, String details) {
        AuditLog log = AuditLog.builder()
                .entityType(entityType)
                .action(action)
                .entityId(entityId)
                .details(details)
                .timestamp(LocalDateTime.now())
                .build();
        return auditLogRepository.save(log);
    }

    @Transactional(value = "secondaryTransactionManager", readOnly = true)
    public List<AuditLog> findByEntityType(String entityType) {
        return auditLogRepository.findByEntityTypeOrderByTimestampDesc(entityType);
    }

    @Transactional(value = "secondaryTransactionManager", readOnly = true)
    public List<AuditLog> findAll() {
        return auditLogRepository.findAll();
    }
}
