package com.ocr.client_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Patient4XXException extends RuntimeException {
    public Patient4XXException(String msg) {
        super(msg);
    }
}
