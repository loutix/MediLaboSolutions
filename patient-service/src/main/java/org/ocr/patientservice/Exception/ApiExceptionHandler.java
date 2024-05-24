package org.ocr.patientservice.Exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(PatientNotFoundException e) {
        HttpStatus NotFound = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(new Date(), e.getMessage(), NotFound.toString());
        log.error(e.getMessage());
        return new ResponseEntity<>(apiException, NotFound);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleApiValidation(MethodArgumentNotValidException e) {
        HttpStatus BadRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(new Date(), e.getMessage(), BadRequest.toString());
        log.error(e.getMessage());
        return new ResponseEntity<>(apiException, BadRequest);
    }


    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormatException(InvalidFormatException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (ex.getTargetType().equals(LocalDate.class)) {
            errors.put("birthDate", "Birth date must be in the format yyyy-MM-dd");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


}
