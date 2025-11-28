package org.example.miniproject1.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.AuditLogs;
import org.example.miniproject1.domain.Student;
import org.example.miniproject1.repo.AuditLogsRepo;
import org.example.miniproject1.repo.StudentRepo;
import org.example.miniproject1.service.KafkaProducerService;
import org.example.miniproject1.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final AuditLogsRepo auditLogsRepo;
    private final KafkaProducerService kafkaProducerService;


    public Student save(Student student) {
        Student saved = studentRepo.save(student);
        // Logs
        AuditLogs auditLogs = AuditLogs.builder()
                .event(" || Student => save_account || ")
                .details("Account created with id=" + saved.getId() + ", email=" + saved.getEmail())
                .timestamp(Instant.now())
                .build();
        auditLogsRepo.save(auditLogs);

        // Produce Event
        kafkaProducerService.sendStudentAccountCreatedEvent("Student account created: " + saved.getId());

        return saved;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepo.findById(id);
    }

    @Override
    public Optional<Student> findByNim(String nim) {
        return studentRepo.findByNim(nim);
    }
}
