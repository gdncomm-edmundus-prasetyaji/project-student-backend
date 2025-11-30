package org.example.miniproject1.controller;

import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.AuditLogs;
import org.example.miniproject1.repo.AuditLogsRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogsRepo auditLogsRepo;

    @GetMapping
    public List<AuditLogs> getAll() {
        return auditLogsRepo.findAll();
    }
}