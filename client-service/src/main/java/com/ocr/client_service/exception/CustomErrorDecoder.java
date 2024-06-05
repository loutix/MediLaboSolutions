package com.ocr.client_service.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {


    private final ErrorDecoder defaultErrorDecoder = new Default();


    @Override
    public Exception decode(String invoqueur, Response response) {

        if (response.status() == 404) {
            return new PatientNotFound("Patient ID not found");
        }
        return defaultErrorDecoder.decode(invoqueur, response);
    }
}
