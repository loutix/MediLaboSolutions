package com.ocr.note_service.service;

import com.ocr.note_service.Exception.IdDifferentException;
import com.ocr.note_service.Exception.PatientNotFoundException;
import com.ocr.note_service.dto.NoteDto;
import com.ocr.note_service.model.Note;
import com.ocr.note_service.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> index() {
        return noteRepository.findAll();
    }

    public List<Note> getNotesByPatientId(Integer id) {
        if (!noteRepository.existsByPatId(id)) {
            throw new PatientNotFoundException(id);
        } else {
            return noteRepository.findByPatId(id).reversed();
        }
    }

    public Note createNote(Integer id, NoteDto noteDto) {

        if (!noteDto.getPatId().equals(id)) {
            throw new IdDifferentException(id, noteDto.getPatId());
        }
        if (!noteRepository.existsByPatId(id)) {
            throw new PatientNotFoundException(id);
        } else {
            String namePatient = noteRepository.findFirstByPatId(id).getPatient();

            Note noteCreated = new Note();
            noteCreated.setPatId(noteDto.getPatId());
            noteCreated.setPatient(namePatient);
            noteCreated.setNote(noteDto.getNote());

            noteRepository.save(noteCreated);

            return noteCreated;
        }


    }
}


