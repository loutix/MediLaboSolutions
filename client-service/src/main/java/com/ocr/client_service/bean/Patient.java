package com.ocr.client_service.bean;

import com.ocr.client_service.constants.GenderEnum;
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

    private GenderEnum gender;

    private String address;

    private String phone;

}
