package com.ocr.assessment_service.controller;


import com.ocr.assessment_service.Service.AssessmentService;
import com.ocr.assessment_service.bean.Note;
import com.ocr.assessment_service.bean.Patient;
import com.ocr.assessment_service.dto.RiskDto;
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


    @GetMapping("/analysis/{id}")
    public ResponseEntity<RiskDto> PatientAnalysisRisk(@PathVariable("id") Integer id) {
        log.info("GET: analysis/{}", id);
        return ResponseEntity.ok(assessmentService.getPatientRisk(id));
    }

    @GetMapping("note/patient/{id}")
    public ResponseEntity<List<Note>> showPatientNote(@PathVariable("id") Integer id) {
        log.info("GET: note/patient/{}", id);
        return ResponseEntity.ok(assessmentService.showPatientNote(id));
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<Patient> showPatient(@PathVariable("id") Integer id) {
        log.info("GET: patient/{}", id);
        return ResponseEntity.ok(assessmentService.showPatient(id));
    }

}
