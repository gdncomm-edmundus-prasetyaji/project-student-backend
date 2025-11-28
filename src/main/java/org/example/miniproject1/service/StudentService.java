package org.example.miniproject1.service;

import org.example.miniproject1.domain.Student;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);
    Optional<Student> findById(Integer id);
    Optional<Student> findByNim(String nim);
}
