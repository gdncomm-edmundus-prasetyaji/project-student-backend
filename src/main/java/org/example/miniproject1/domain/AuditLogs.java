package org.example.miniproject1.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "audit_logs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AuditLogs {
    @Id
    private String id;
    private String event;
    private String details;
    private Instant timestamp;
}
