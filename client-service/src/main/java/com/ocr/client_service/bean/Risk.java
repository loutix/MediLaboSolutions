package com.ocr.client_service.bean;


import com.ocr.client_service.constants.RiskEnum;
import jakarta.validation.constraints.NotNull;

public record Risk(
        @NotNull(message = "patientId can not be null")
        Integer patientId,
        @NotNull(message = "Risk can not be null")
        RiskEnum riskEnum) {
}
