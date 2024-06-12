package com.ocr.assessment_service.dto;

import com.ocr.assessment_service.constants.Risk;

public record RiskDto(
        Integer patientId,
        Risk risk) {
}
