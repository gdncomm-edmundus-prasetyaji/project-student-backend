package org.example.miniproject1.service;

public interface KafkaProducerService {
    void sendStudentAccountCreatedEvent(String message);
    void sendLecturerAccountCreatedEvent(String message);
}
