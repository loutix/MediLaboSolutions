package com.ocr.client_service.controller;

import com.ocr.client_service.beans.Patient;
import com.ocr.client_service.proxies.PatientProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class clientController {

    private final PatientProxy patientProxy;

    public clientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @GetMapping()
    public String index() {
        return "Home";
    }

    @GetMapping("/patients")
    public String patients(Model model) {
        List<Patient> patientList = patientProxy.getAllPatients();
        model.addAttribute("patientList", patientList);
        return "PatientTable";
    }

    @GetMapping("/patients/hello")
    public String patients() {
        return "Patient";
    }



}
