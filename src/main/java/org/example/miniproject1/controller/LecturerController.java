package org.example.miniproject1.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.example.miniproject1.domain.Lecturer;
import org.example.miniproject1.service.LecturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/lecturers")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @PostMapping
    @Operation(summary = "Create Lecturer Account")
    public ResponseEntity<Lecturer> createAccount(@RequestBody Lecturer lecturer) {
        Lecturer createdLecturer = lecturerService.save(lecturer);
        return ResponseEntity.ok(createdLecturer);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Lecturer Details by ID")
    public ResponseEntity<Optional<Lecturer>> findById(@PathVariable Integer id) {
        Optional<Lecturer> lecturer = lecturerService.findById(id);
        return ResponseEntity.ok(lecturer);
    }

    @GetMapping("/{nip}")
    @Operation(summary = "Get Lecturer Details by NIP")
    public ResponseEntity<Optional<Lecturer>> findByNip(@PathVariable String nip) {
        Optional<Lecturer> lecturer = lecturerService.findByNip(nip);
        return ResponseEntity.ok(lecturer);
    }
}