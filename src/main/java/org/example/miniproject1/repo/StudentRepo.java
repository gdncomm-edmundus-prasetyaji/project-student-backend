package org.example.miniproject1.repo;

import org.example.miniproject1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Override
    Optional<Student> findById(Integer id);

    Optional<Student> findByNim(String nim);
}