package com.ocr.client_service.proxies;

import com.ocr.client_service.beans.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "gateway-service")
public interface PatientProxy {
    @GetMapping("/patients")
    List<Patient> getAllPatients();
}
