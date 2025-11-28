package org.example.miniproject1.controller;


import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.Student;
import org.example.miniproject1.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createAccount(@RequestBody Student student) {
        Student createdStudent = studentService.save(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping
    public ResponseEntity<Optional<Student>> findById(@RequestParam(required = true) Integer id) {
        Optional<Student> student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<Optional<Student>> findByNim(@RequestParam(required = true) String nim) {
        Optional<Student> student = studentService.findByNim(nim);
        return ResponseEntity.ok(student);
    }
}