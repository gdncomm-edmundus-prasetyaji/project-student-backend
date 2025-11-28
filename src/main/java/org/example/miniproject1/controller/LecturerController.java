package org.example.miniproject1.controller;

import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.Lecturer;
import org.example.miniproject1.service.LecturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @PostMapping
    public ResponseEntity<Lecturer> createAccount(@RequestBody Lecturer lecturer) {
        Lecturer createdLecturer = lecturerService.save(lecturer);
        return ResponseEntity.ok(createdLecturer);
    }

    @GetMapping
    public ResponseEntity<Optional<Lecturer>> findById(@RequestParam(required = true) Integer id) {
        Optional<Lecturer> lecturer = lecturerService.findById(id);
        return ResponseEntity.ok(lecturer);
    }

    @GetMapping
    public ResponseEntity<Optional<Lecturer>> findByNim(@RequestParam(required = true) String nip) {
        Optional<Lecturer> lecturer = lecturerService.findByNip(nip);
        return ResponseEntity.ok(lecturer);
    }
}