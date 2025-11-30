package org.example.miniproject1.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.Student;
import org.example.miniproject1.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @Operation(summary = "Create Student Account")
    public ResponseEntity<Student> createAccount(@RequestBody Student student) {
        Student createdStudent = studentService.save(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Student Details by Id")
    public ResponseEntity<Optional<Student>> findById(@PathVariable Integer id) {
        Optional<Student> student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{nim}")
    @Operation(summary = "Get Student Details by NIM")
    public ResponseEntity<Optional<Student>> findByNim(@PathVariable String nim) {
        Optional<Student> student = studentService.findByNim(nim);
        return ResponseEntity.ok(student);
    }
}