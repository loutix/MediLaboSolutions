package com.ocr.note_service.controller;


import com.ocr.note_service.dto.NoteDto;
import com.ocr.note_service.model.Note;
import com.ocr.note_service.service.NoteServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/note-service")
public class NoteController {

    private final NoteServiceImpl noteServiceImpl;

    public NoteController(NoteServiceImpl noteServiceImpl) {
        this.noteServiceImpl = noteServiceImpl;
    }

    @GetMapping("/index")
    public ResponseEntity<List<Note>> index() {
        log.info("GET: /index");
        return ResponseEntity.ok(noteServiceImpl.index());
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Note>> showPatientNote(@PathVariable("id") Integer id) {
        log.info("GET: /note-service/patient/{}", id);
        return ResponseEntity.ok(noteServiceImpl.getNotesByPatientId(id));
    }

    @PostMapping("/patient/{id}")
    public ResponseEntity<Note> createNote(@PathVariable("id") Integer id, @Valid @RequestBody NoteDto noteDto) {
        log.info("POST:  /note-service/patient/{}", id);
        return ResponseEntity.ok(noteServiceImpl.createNote(id, noteDto));
    }

}
