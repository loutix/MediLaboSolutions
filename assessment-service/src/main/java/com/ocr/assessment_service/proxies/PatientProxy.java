package com.ocr.assessment_service.proxies;


import com.ocr.assessment_service.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gateway-service", url = "${gateway-service.url}", contextId = "patient-service")

public interface PatientProxy {
    @GetMapping("/patient-service/patient/{id}")
    Patient getPatientId(@PathVariable("id") Integer id);
}
