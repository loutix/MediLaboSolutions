package org.ocr.patientservice.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ocr.patientservice.constants.Gender;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDto {

    @NotBlank(message = "First name is mandatory")
    private String first_name;

    @NotBlank(message = "Last name is mandatory")
    private String last_name;

    @NotNull(message = "Birth date is mandatory")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birth_date;

    @NotNull(message = "Gender is mandatory")
    private Gender gender;

    @Size(max = 50, message = "Address length must be less than or equal to 50 characters")
    private String address;

    @Pattern(regexp = "^$|\\d{3}-\\d{3}-\\d{4}", message = "Phone number must be in the format 111-222-3333")
    private String phone;

}
