package org.example.miniproject1.service;

public interface KafkaProducerService {
    void sendAccountCreatedEvent(String message);
}
