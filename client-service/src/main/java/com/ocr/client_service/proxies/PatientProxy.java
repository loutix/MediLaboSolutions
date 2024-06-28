package com.ocr.client_service.proxies;

import com.ocr.client_service.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patient-service", url = "${gateway-service.url}", path = "patient-service")
public interface PatientProxy {
    @GetMapping("/patients")
    List<Patient> getAllPatients();

    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable("id") Integer id);
}
