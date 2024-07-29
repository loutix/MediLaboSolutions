package com.ocr.client_service.dto;

import com.ocr.client_service.constants.GenderEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PatientDto(
        @NotBlank String first_name,
        @NotBlank String last_name,
        @NotBlank LocalDate birth_date,
        @NotNull GenderEnum gender,
        String  address ,
        String phone) {
}
