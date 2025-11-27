package org.example.miniproject1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student extends User{

    @Column(nullable = false, unique = true)
    private String nim;

    private String gpa;
}
