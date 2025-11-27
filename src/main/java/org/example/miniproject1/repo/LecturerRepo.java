package org.example.miniproject1.repo;

import org.example.miniproject1.domain.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturerRepo extends JpaRepository<Lecturer, Integer> {
    @Override
    Optional<Lecturer> findById(Integer id);

    Optional<Lecturer> findByNip(String nip);
}
