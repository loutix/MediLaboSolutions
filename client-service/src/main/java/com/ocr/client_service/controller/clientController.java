package com.ocr.client_service.controller;

import com.ocr.client_service.beans.Patient;
import com.ocr.client_service.proxies.PatientProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/client-service")
public class clientController {

    private final PatientProxy patientProxy;

    public clientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @GetMapping("/home")
    public String index() {
        return "Home";
    }

    @GetMapping("/patients")
    public String patients(Model model) {
        List<Patient> patientList = patientProxy.getAllPatients();
        model.addAttribute("patientList", patientList);
        return "PatientTable";
    }

    @GetMapping("/patient/{id}")
    public String showPatient(@PathVariable(value = "id") Integer id , Model model) {
        Patient patient = patientProxy.getPatient(id);
        model.addAttribute("patient", patient);
        return "ShowPatient";
    }



}
