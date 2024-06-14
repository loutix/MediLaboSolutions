package com.ocr.assessment_service.bean;

import com.ocr.assessment_service.constants.RiskEnum;
import jakarta.validation.constraints.NotNull;

public record Risk(
        @NotNull(message = "patientId can not be null")
        Integer patientId,
        @NotNull(message = "Risk can not be null")
        RiskEnum riskEnum) {
}
