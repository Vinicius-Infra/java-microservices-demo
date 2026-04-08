package com.demo.microservices.controller;

import com.demo.microservices.model.AuditLog;
import com.demo.microservices.repository.AuditLogRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/audit")
@Tag(name = "Audit API", description = "Recebe e armazena logs de outros microserviços")
public class AuditController {

    private final AuditLogRepository repository;

    public AuditController(AuditLogRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/log")
    @Operation(summary = "Registra um novo evento de auditoria")
    public AuditLog createLog(@RequestBody AuditLog log) {
        log.setTimestamp(LocalDateTime.now());
        return repository.save(log);
    }

    @GetMapping
    @Operation(summary = "Lista todos os logs registrados")
    public List<AuditLog> getAllLogs() {
        return repository.findAll();
    }
}