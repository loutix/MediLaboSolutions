package com.ocr.client_service.controller;

import com.ocr.client_service.dto.Note;
import com.ocr.client_service.dto.Patient;
import com.ocr.client_service.proxies.NoteProxy;
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

    private final NoteProxy noteProxy;

    public clientController(PatientProxy patientProxy, NoteProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
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
    public String showPatient(@PathVariable(value = "id") Integer id, Model model) {


        Patient patient = patientProxy.getPatient(id);
        model.addAttribute("patient", patient);

        List<Note> noteList = noteProxy.getNoteByPatientId(id);
        model.addAttribute("noteList", noteList);

        return "ShowPatient";


    }


}
