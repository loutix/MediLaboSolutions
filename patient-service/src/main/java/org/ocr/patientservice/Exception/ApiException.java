package org.ocr.patientservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ApiException {
    private final Date timeStamp;
    private final String message;
    private final String details;
}
