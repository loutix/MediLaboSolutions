package com.ocr.assessment_service.proxies;


import com.ocr.assessment_service.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service", path = "patient-service")
//@FeignClient(name = "gateway-service", url = "${gateway-service.url}", path = "patient-service", contextId = "patient-service")
public interface PatientProxy {
    @GetMapping("/patient/{id}")
    Patient getPatientId(@PathVariable("id") Integer id);
}
