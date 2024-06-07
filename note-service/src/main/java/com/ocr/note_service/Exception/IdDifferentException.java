package com.ocr.note_service.Exception;

public class IdDifferentException extends RuntimeException {
    public IdDifferentException(Integer urlId, Integer dtoId) {
        super("URL id " + urlId + " is different to DTO id " + dtoId);
    }
}
