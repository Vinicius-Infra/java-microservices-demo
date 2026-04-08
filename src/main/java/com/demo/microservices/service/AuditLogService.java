package com.demo.microservices.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.demo.microservices.model.AuditLog;
import com.demo.microservices.repository.AuditLogRepository;

@Service
public class AuditLogService {

    private final AuditLogRepository repository;

    public AuditLogService(AuditLogRepository repository) {
        this.repository = repository;
    }

    public List<AuditLog> findAll() {
        return repository.findAll();
    }
    
    public AuditLog findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Log de auditoria não encontrado com id " + id));
    }

    public AuditLog save(AuditLog log) {
        AuditLog saved = repository.save(log);
        System.out.println(">>> Log de Auditoria registrado: " + saved);
        return saved;
    }
}