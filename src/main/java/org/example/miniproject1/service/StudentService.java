package org.example.miniproject1.service;

import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.AuditLogs;
import org.example.miniproject1.domain.Student;
import org.example.miniproject1.repo.AuditLogsRepo;
import org.example.miniproject1.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final AuditLogsRepo auditLogsRepo;

    public Student save(Student student) {
        Student saved = studentRepo.save(student);

        AuditLogs auditLogs = AuditLogs.builder()
                .event(" || Student => save_account || ")
                .details("Account created with id=" + saved.getId() + ", email=" + saved.getEmail())
                .timestamp(Instant.now())
                .build();
        auditLogsRepo.save(auditLogs);

        return saved;
    }

    public Optional<Student> findById(Integer id) {
        return studentRepo.findById(id);
    }

    public Optional<Student> findByNim(String nim) {
        return studentRepo.findByNim(nim);
    }
}
