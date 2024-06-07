package com.ocr.client_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {

    private String id;

    @NotNull(message = "Patient ID cannot be null")
    private Integer patId;

    @NotBlank(message = "Patient name cannot be blank")
    private String patient;

    @NotBlank(message = "Note cannot be blank")
    private String note;
}
