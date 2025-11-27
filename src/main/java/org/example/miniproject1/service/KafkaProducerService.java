package org.example.miniproject1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendAccountCreatedEvent(String message) {
        kafkaTemplate.send("account-created-topic", message);
    }
}

