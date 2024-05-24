package org.ocr.patientservice.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.ocr.patientservice.dto.PatientDto;
import org.ocr.patientservice.model.Patient;
import org.ocr.patientservice.service.PatientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(path = "patients")
public class PatientController {

    private final PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public Set<Patient> index() {
        log.info("GET:  /");
        return patientService.index();
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Patient> show(@PathVariable("id") Integer id) {
        log.info("GET:  /update/{}", id);
        Optional<Patient> patient = patientService.findPatient(id);
        return ResponseEntity.of(patient);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> update(@PathVariable("id") Integer id, @Valid @RequestBody PatientDto patientDto) {
        log.info("PUT:  /update/{}", id);
        Patient patient = patientService.update(id, patientDto);
        return ResponseEntity.ok(patient);
    }


}
