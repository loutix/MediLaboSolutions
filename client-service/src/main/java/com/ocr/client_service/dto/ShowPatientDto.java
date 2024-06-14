package com.ocr.client_service.dto;


import com.ocr.client_service.bean.Note;
import com.ocr.client_service.bean.Patient;
import com.ocr.client_service.bean.Risk;
import com.ocr.client_service.constants.GenderEnum;
import com.ocr.client_service.constants.RiskEnum;

import java.time.LocalDate;
import java.util.List;

public class ShowPatientDto {
    public Integer id;
    public String first_name;
    public String last_name;
    public LocalDate birth_date;
    public GenderEnum gender;
    public String address;
    public String phone;
    public List<Note> noteList;
    public RiskEnum risk;

    public ShowPatientDto(Patient patient, List<Note> noteList, Risk risk) {
        this.id = patient.getId();
        this.first_name = patient.getFirst_name();
        this.last_name = patient.getLast_name();
        this.birth_date = patient.getBirth_date();
        this.gender = patient.getGender();
        this.address = patient.getAddress();
        this.phone = patient.getPhone();
        this.noteList = noteList;
        this.risk = risk.risk();
    }
}
