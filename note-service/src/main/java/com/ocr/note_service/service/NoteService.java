package com.ocr.note_service.service;

import com.ocr.note_service.dto.NoteDto;
import com.ocr.note_service.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> index();

    List<Note> getNotesByPatientId(Integer id);

    Note createNote(Integer id, NoteDto noteDto);
}
