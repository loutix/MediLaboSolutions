package com.ocr.client_service.proxies;


import com.ocr.client_service.dto.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "note-service", url = "localhost:8080")
public interface NoteProxy {
    @GetMapping("note-service/patient/{id}")
    List<Note> getNoteByPatientId(@PathVariable("id") Integer id);


    @PostMapping("note-service/patient/{id}")
    Note addNewNote(@PathVariable(value = "id") Integer id, Note note);


}
