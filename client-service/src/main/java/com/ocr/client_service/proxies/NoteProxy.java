package com.ocr.client_service.proxies;


import com.ocr.client_service.bean.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "note-service" ,url = "${gateway-service.url}", path = "note-service")
public interface NoteProxy {
    @GetMapping("/patient/{id}")
    List<Note> getNoteByPatientId(@PathVariable("id") Integer id);


    @PostMapping("/patient/{id}")
    void addNewNote(@PathVariable(value = "id") Integer id, Note note);


}
