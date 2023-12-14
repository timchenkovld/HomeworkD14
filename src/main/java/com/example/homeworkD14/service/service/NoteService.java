package com.example.homeworkD14.service.service;

import com.example.homeworkD14.service.dto.NoteDto;
import com.example.homeworkD14.service.exception.NoteNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface NoteService {

    List<NoteDto> listAll();

    NoteDto add(NoteDto note);

    void deleteById(UUID id) throws NoteNotFoundException;

    void update(NoteDto note) throws NoteNotFoundException;

    NoteDto getById(UUID id) throws NoteNotFoundException;
}
