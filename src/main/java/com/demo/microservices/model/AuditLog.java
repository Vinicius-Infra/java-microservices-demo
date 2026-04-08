package com.demo.microservices.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;     // ID original vindo da API Kotlin
    private String userName;   // Nome para facilitar auditoria rápida
    private String operation;  // "CREATE", "UPDATE", "DELETE"
    private LocalDateTime timestamp;
}