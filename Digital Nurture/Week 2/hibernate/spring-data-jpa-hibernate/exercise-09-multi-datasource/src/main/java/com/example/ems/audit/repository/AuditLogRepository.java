package com.example.ems.audit.repository;

import com.example.ems.audit.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByEntityTypeOrderByTimestampDesc(String entityType);
}
