package org.example.miniproject1.service;

import org.example.miniproject1.domain.Lecturer;
import org.example.miniproject1.domain.Student;

import java.util.Optional;

public interface LecturerService {
    Lecturer save(Lecturer lecturer);
    Optional<Lecturer> findById(Integer id);
    Optional<Lecturer> findByNip(String nim);
}
