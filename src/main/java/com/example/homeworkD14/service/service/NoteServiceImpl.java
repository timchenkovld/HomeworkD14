package com.example.homeworkD14.service.service;

import com.example.homeworkD14.entity.NoteEntity;
import com.example.homeworkD14.repository.NoteRepository;
import com.example.homeworkD14.repository.OldNoteRepository;
import com.example.homeworkD14.service.dto.NoteDto;
import com.example.homeworkD14.service.exception.NoteNotFoundException;
import com.example.homeworkD14.service.mapping.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public List<NoteDto> listAll() {
        return noteMapper.toNoteDtos(noteRepository.findAll());
    }

    @Override
    public NoteDto add(NoteDto note) {
        NoteEntity entity = noteMapper.toNoteEntity(note);
        entity.setId(null);
        return noteMapper.toNoteDto(noteRepository.save(entity));
    }

    @Override
    public void deleteById(UUID id) throws NoteNotFoundException {
        getById(id);
        noteRepository.deleteById(id);
    }

    @Override
    public void update(NoteDto note) throws NoteNotFoundException {
        if (Objects.isNull(note.getId())) {
            throw new NoteNotFoundException();
        }
        getById(note.getId());
        noteRepository.save(noteMapper.toNoteEntity(note));
    }

    @Override
    public NoteDto getById(UUID id) throws NoteNotFoundException {
        Optional<NoteEntity> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return noteMapper.toNoteDto(optionalNote.get());
        } else {
            throw new NoteNotFoundException(id);
        }
    }
}
