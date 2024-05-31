package com.ocr.client_service.proxies;

import com.ocr.client_service.beans.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "patient-service", url = "localhost:8082")
public interface PatientProxy {
    @GetMapping("patient-service/patients")
    List<Patient> getAllPatients();
}
