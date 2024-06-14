package com.ocr.client_service.bean;

import com.ocr.client_service.constants.RiskEnum;

public record Risk(
        Integer patientId,
        RiskEnum risk) {
}
