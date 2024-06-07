package com.ocr.note_service.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ApiException {
    private final Date timeStamp;
    private final List<FieldValidationError> msgError;
    private final String details;
}
