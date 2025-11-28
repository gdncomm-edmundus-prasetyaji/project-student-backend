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
    public void sendAccountCreatedEvent(String message) {
        kafkaTemplate.send("account-created-topic", message);
    }
}

