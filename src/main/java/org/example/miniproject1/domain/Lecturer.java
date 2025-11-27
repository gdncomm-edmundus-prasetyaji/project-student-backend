package org.example.miniproject1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "lecturers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Lecturer extends User{
    @Column(nullable = false, unique = true)
    private String nip;
    private String expertise;
}
