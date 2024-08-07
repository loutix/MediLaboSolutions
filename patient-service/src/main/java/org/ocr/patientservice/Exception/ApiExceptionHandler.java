package org.ocr.patientservice.Exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(PatientNotFoundException e) {
        HttpStatus NotFound = HttpStatus.NOT_FOUND;

        final List<FieldValidationError> errorsListList = new ArrayList<>();
        errorsListList.add(new FieldValidationError("id", e.getMessage()));

        ApiException apiException = new ApiException(new Date(), errorsListList, NotFound.toString());
        log.error(e.getMessage());
        return new ResponseEntity<>(apiException, NotFound);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleApiValidation(MethodArgumentNotValidException e) {
        HttpStatus BadRequest = HttpStatus.BAD_REQUEST;

        final List<FieldValidationError> errorsList = new ArrayList<FieldValidationError>();

        for (final FieldError error : e.getBindingResult().getFieldErrors()) {
            errorsList.add(new FieldValidationError(error.getField(), error.getDefaultMessage()));
        }
        ApiException apiException = new ApiException(new Date(), errorsList, BadRequest.toString());
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
