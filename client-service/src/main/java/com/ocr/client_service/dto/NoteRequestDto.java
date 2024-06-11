package com.ocr.client_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequestDto {
    @NotNull
    private Integer patId;

    @NotBlank
    private String first_name;

    @NotBlank
    private String last_name;

    @NotBlank(message = "Note cannot be blank")
    private String note;
}
