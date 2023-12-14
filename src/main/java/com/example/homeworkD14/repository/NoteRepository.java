package com.example.homeworkD14.repository;

import com.example.homeworkD14.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<NoteEntity, UUID> {
}
