package com.ocr.assessment_service.proxies;

import com.ocr.assessment_service.bean.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "gateway-service", url = "${gateway-service.url}", contextId = "note-service")

public interface NoteProxy {
    @GetMapping("/note-service/patient/{id}")
    List<Note> getNoteByPatientId(@PathVariable("id") Integer id);
}
