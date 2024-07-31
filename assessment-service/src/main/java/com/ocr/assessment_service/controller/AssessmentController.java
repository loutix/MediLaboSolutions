package com.ocr.assessment_service.controller;


import com.ocr.assessment_service.Service.AssessmentServiceImpl;
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
public class AssessmentController {

    private final AssessmentServiceImpl assessmentServiceImpl;

    public AssessmentController(AssessmentServiceImpl assessmentServiceImpl) {
        this.assessmentServiceImpl = assessmentServiceImpl;
    }

    @GetMapping("/analysis/{id}")
    public ResponseEntity<Risk> PatientAnalysisRisk(@PathVariable("id") Integer id) {
        log.info("GET: analysis/{}", id);
        return ResponseEntity.ok(assessmentServiceImpl.getPatientRisk(id));
    }

}
