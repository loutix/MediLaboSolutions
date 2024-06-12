package com.ocr.assessment_service.bean;

import com.ocr.assessment_service.constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

    private Integer id;

    private String first_name;

    private String last_name;

    private LocalDate birth_date;

    private Gender gender;

    private String address;

    private String phone;


    public int calculateAge() {
        return this.getBirth_date().until(LocalDate.now()).getYears();
    }

    public boolean isOver30YearsOld() {
        return calculateAge() > 30;
    }

}
