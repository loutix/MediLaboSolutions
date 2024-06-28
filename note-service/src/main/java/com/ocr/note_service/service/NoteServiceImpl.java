package com.ocr.note_service.service;

import com.ocr.note_service.Exception.IdDifferentException;
import com.ocr.note_service.Exception.PatientNotFoundException;
import com.ocr.note_service.dto.NoteDto;
import com.ocr.note_service.model.Note;
import com.ocr.note_service.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    /**
     * Return the complete list of notes from DB
     *
     * @return a list of all notes
     */
    @Override
    public List<Note> index() {
        return noteRepository.findAll();
    }

    /**
     * Find all notes with the patient ID
     *
     * @param id patient ID
     * @return a list of Note
     * @throws PatientNotFoundException if the patient ID does not exist.
     */
    @Override
    public List<Note> getNotesByPatientId(Integer id) {
        if (!noteRepository.existsByPatId(id)) {
            throw new PatientNotFoundException(id);
        } else {
            return noteRepository.findByPatId(id).reversed();
        }
    }


    /**
     * Save a new note for the patient with the param ID
     *
     * @param id      patient ID
     * @param noteDto DTO to create a new Note
     * @return the note created
     * @throws IdDifferentException if the ID in the DTO does not match the patient ID.
     * @throws PatientNotFoundException if the patient ID does not exist.
     */
    @Override
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


