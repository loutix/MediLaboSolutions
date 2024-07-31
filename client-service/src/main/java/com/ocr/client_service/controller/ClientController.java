package com.ocr.client_service.controller;

import com.ocr.client_service.bean.Note;
import com.ocr.client_service.bean.Patient;
import com.ocr.client_service.bean.Risk;
import com.ocr.client_service.dto.EditPatientDto;
import com.ocr.client_service.dto.NoteRequestDto;
import com.ocr.client_service.dto.PatientDto;
import com.ocr.client_service.dto.ShowPatientDto;
import com.ocr.client_service.proxies.NoteProxy;
import com.ocr.client_service.proxies.PatientProxy;
import com.ocr.client_service.proxies.RiskProxy;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/client-service")
public class ClientController {

    @Value("${gateway-service.url}")
    private String gatewayServiceUrl;

    private final PatientProxy patientProxy;

    private final NoteProxy noteProxy;

    private final RiskProxy riskProxy;

    public ClientController(PatientProxy patientProxy, NoteProxy noteProxy, RiskProxy riskProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
        this.riskProxy = riskProxy;
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
        List<Note> noteList = noteProxy.getNoteByPatientId(id);
        Risk patientRisk = riskProxy.getPatientRisk(id);

        ShowPatientDto showPatientDto = new ShowPatientDto(patient, noteList, patientRisk);

        model.addAttribute("showPatientDto", showPatientDto);

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
    public String formNote(@Valid @ModelAttribute("noteRequestDto") NoteRequestDto noteRequestDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "AddNote";
        }

        Note noteAdded = new Note();
        noteAdded.setPatId(noteRequestDto.getPatId());
        noteAdded.setNote(noteRequestDto.getNote());

        Integer id = noteAdded.getPatId();

        noteProxy.addNewNote(id, noteAdded);

        return "redirect:/client-service/patient/" + id + "?success";
    }

    @GetMapping("/patient/{id}/edit")
    public String editPatient(@PathVariable(value = "id") Integer id, Model model) {

        Patient patient = patientProxy.getPatient(id);

        EditPatientDto editPatientDto = new EditPatientDto(
                patient.getId(),
                patient.getFirst_name(),
                patient.getLast_name(),
                patient.getBirth_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                patient.getGender(),
                patient.getAddress(),
                patient.getPhone()
        );

        model.addAttribute("editPatientDto", editPatientDto);

        return "EditPatient";
    }

    @PostMapping("/patient/update")
    public String updatePatient(@Valid @ModelAttribute("editPatientDto") EditPatientDto editPatientDto, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "EditPatient";
        }

        Integer id = editPatientDto.getId();

        PatientDto patientDto = new PatientDto(
                editPatientDto.getFirst_name(),
                editPatientDto.getLast_name(),
                LocalDate.parse(editPatientDto.getBirth_date()),
                editPatientDto.getGender(),
                editPatientDto.getAddress(),
                editPatientDto.getPhone()
        );


        patientProxy.updatePatient(id, patientDto);

        return "redirect:/client-service/patient/" + id + "?success_edit";
    }


}
