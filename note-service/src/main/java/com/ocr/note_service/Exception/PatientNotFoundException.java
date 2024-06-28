package com.ocr.note_service.Exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Integer id) {
        super("Patient with ID " + id + " not found");
    }
}
