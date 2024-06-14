package com.ocr.assessment_service.controller;


import com.ocr.assessment_service.Service.AssessmentService;
import com.ocr.assessment_service.bean.Risk;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/assessment-service")
public class assessmentController {

    private final AssessmentService assessmentService;

    public assessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GetMapping("/analysis/{id}")
    public ResponseEntity<Risk> PatientAnalysisRisk(@PathVariable("id") Integer id) {
        log.info("GET: analysis/{}", id);
        return ResponseEntity.ok(assessmentService.getPatientRisk(id));
    }

}
