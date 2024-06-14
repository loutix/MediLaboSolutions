package com.ocr.assessment_service.bean;

import jakarta.validation.constraints.NotNull;

public record Risk(
        @NotNull(message = "patientId can not be null")
        Integer patientId,
        @NotNull(message = "Risk can not be null")
        com.ocr.assessment_service.constants.Risk risk) {
}
