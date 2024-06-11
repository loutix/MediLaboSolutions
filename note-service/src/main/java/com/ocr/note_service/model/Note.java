package com.ocr.note_service.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "noteCollection")
public class Note {

    @NotNull
    private Integer patId;

    @NotBlank
    private String patient;

    @NotBlank
    private String note;

    //todo rajouter un champ date
}
