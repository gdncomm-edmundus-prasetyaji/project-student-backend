package org.example.miniproject1.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.example.miniproject1.service.KafkaProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendStudentAccountCreatedEvent(String message) {
        kafkaTemplate.send("account-created-student", message);
    }

    @Override
    public void sendLecturerAccountCreatedEvent(String message) {
        kafkaTemplate.send("account-created-lecturer", message);
    }
}

