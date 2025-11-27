package org.example.miniproject1.service;

import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.AuditLogs;
import org.example.miniproject1.domain.Lecturer;
import org.example.miniproject1.repo.AuditLogsRepo;
import org.example.miniproject1.repo.LecturerRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LecturerService {
    private final LecturerRepo lecturerRepo;
    private final AuditLogsRepo auditLogsRepo;

    public Lecturer save(Lecturer lecturer) {
        Lecturer saved = lecturerRepo.save(lecturer);

        AuditLogs auditLogs = AuditLogs.builder()
                .event(" || Lecturer => save_account || ")
                .details("Account created with id=" + saved.getId() + ", email=" + saved.getEmail())
                .timestamp(Instant.now())
                .build();
        auditLogsRepo.save(auditLogs);

        return saved;
    }

    Optional<Lecturer> findById(Integer id) {
        return lecturerRepo.findById(id);
    }

    Optional<Lecturer> findByNip(String nip) {
        return lecturerRepo.findByNip(nip);
    }
}
