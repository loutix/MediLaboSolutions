package com.ocr.assessment_service.controller;


import com.ocr.assessment_service.assessmentService.AssessmentService;
import com.ocr.assessment_service.bean.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/assessment-service")
public class assessmentController {

    private final AssessmentService assessmentService;

    public assessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GetMapping("/index")
    public ResponseEntity<String> hello() {
        log.info("GET: /hello");
        return ResponseEntity.ok("hello");

    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Note>> showPatientNote(@PathVariable("id") Integer id) {
        log.info("GET: /patient/{}", id);
        return ResponseEntity.ok(assessmentService.showPatientNote(id));
    }

}
