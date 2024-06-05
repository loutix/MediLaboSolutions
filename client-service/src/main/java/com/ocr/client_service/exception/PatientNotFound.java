package com.ocr.client_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PatientNotFound extends RuntimeException {
    public PatientNotFound(String msg) {
        super(msg);
    }
}
