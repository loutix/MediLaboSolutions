package com.ocr.assessment_service.proxies;

import com.ocr.assessment_service.bean.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "note-service", path = "note-service")
//@FeignClient(name = "gateway-service", url = "${gateway-service.url}", path = "note-service", contextId = "note-service")
public interface NoteProxy {
    @GetMapping("/patient/{id}")
    List<Note> getNoteByPatientId(@PathVariable("id") Integer id);
}
