package com.ocr.client_service.proxies;


import com.ocr.client_service.dto.Note;
import com.ocr.client_service.dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "note-service", url = "localhost:8080")
public interface NoteProxy {
    @GetMapping("note-service/patient/{id}")
    List<Note> getNoteByPatientId(@PathVariable("id") Integer id);

}
