package com.ocr.assessment_service.bean;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @NotNull(message = "Patient ID cannot be null")
    private Integer patId;

    @NotBlank(message = "Note cannot be blank")
    private String note;
}
