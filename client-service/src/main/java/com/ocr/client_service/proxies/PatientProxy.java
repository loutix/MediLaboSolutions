package com.ocr.client_service.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway-service", url = "http://localhost:8761")
public interface PatientProxy {
   // @GetMapping("/patient-service/patients")
   // List<Patient> getAllPatients();
}
