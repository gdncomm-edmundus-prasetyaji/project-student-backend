package org.example.miniproject1.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.AuditLogs;
import org.example.miniproject1.domain.Lecturer;
import org.example.miniproject1.repo.AuditLogsRepo;
import org.example.miniproject1.repo.LecturerRepo;
import org.example.miniproject1.service.KafkaProducerService;
import org.example.miniproject1.service.LecturerService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LecturerServiceImpl implements LecturerService {
    private final LecturerRepo lecturerRepo;
    private final AuditLogsRepo auditLogsRepo;
    private final KafkaProducerService kafkaProducerService;

    public Lecturer save(Lecturer lecturer) {
        lecturer.setActive(true);
        Lecturer saved = lecturerRepo.save(lecturer);
        // Logs
        AuditLogs auditLogs = AuditLogs.builder()
                .event(" || Lecturer => save_account || ")
                .details("Account created with id=" + saved.getId() + ", email=" + saved.getEmail())
                .timestamp(Instant.now())
                .build();
        auditLogsRepo.save(auditLogs);

        // Produce Event
        kafkaProducerService.sendLecturerAccountCreatedEvent("Lecturer account created: " + saved.getId());

        return saved;
    }

    @Override
    public Optional<Lecturer> findById(Integer id) {
        return lecturerRepo.findById(id);
    }

    @Override
    public Optional<Lecturer> findByNip(String nip) {
        return lecturerRepo.findByNip(nip);
    }
}
