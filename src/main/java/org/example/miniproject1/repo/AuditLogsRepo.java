package org.example.miniproject1.repo;

import org.example.miniproject1.domain.AuditLogs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditLogsRepo extends MongoRepository<AuditLogs, Integer> {
}
