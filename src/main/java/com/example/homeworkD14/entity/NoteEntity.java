package com.example.homeworkD14.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "note")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "title", length = 15, nullable = false)
    @Size(min = 1, max = 15)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;
}
