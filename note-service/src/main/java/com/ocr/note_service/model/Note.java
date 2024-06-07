package com.ocr.note_service.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "noteCollection")
public class Note {

    @Id
    private String id;

    @NotNull
    private Integer patId;

    @NotBlank
    private String patient;

    @NotBlank
    private String note;

    //todo rajouter un champ date
}
