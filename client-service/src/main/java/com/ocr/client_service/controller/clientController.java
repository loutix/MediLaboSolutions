package com.ocr.client_service.controller;

import com.ocr.client_service.bean.Note;
import com.ocr.client_service.dto.NoteRequestDto;
import com.ocr.client_service.bean.Patient;
import com.ocr.client_service.proxies.NoteProxy;
import com.ocr.client_service.proxies.PatientProxy;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/patient/{id}/note")
    public String formNote(@PathVariable(value = "id") Integer id, Model model) {

        Patient patient = patientProxy.getPatient(id);

        NoteRequestDto noteRequestDto = new NoteRequestDto();
        noteRequestDto.setPatId(patient.getId());
        noteRequestDto.setFirst_name(patient.getFirst_name());
        noteRequestDto.setLast_name(patient.getLast_name());


        model.addAttribute("noteRequestDto", noteRequestDto);

        return "AddNote";
    }

    @PostMapping("patient/note")
    public String formNote(@Valid @ModelAttribute("noteRequestDto") NoteRequestDto noteRequestDto, BindingResult result) {
        if (result.hasErrors()) {
            return "AddNote";
        }

        Note noteAdded = new Note();
        noteAdded.setPatId(noteRequestDto.getPatId());
        noteAdded.setNote(noteRequestDto.getNote());

        Integer id = noteAdded.getPatId();

        noteProxy.addNewNote(id,noteAdded);

        return "redirect:/client-service/patient/"+ id +"?success";

    }


}
