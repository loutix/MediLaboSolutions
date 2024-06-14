package com.ocr.assessment_service.proxies;


import com.ocr.assessment_service.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service", url = "localhost:8090", path = "patient-service")
public interface PatientProxy {
    @GetMapping("/patient/{id}")
    Patient getPatientId(@PathVariable("id") Integer id);
}
