package com.ocr.note_service.Exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({PatientNotFoundException.class, IdDifferentException.class})
    public ResponseEntity<Object> handleApiRequestException(RuntimeException e) {
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



}
