package com.ocr.client_service.proxies;

import com.ocr.client_service.bean.Patient;
import com.ocr.client_service.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "gateway-service", url = "${gateway-service.url}", path = "patient-service", contextId = "patient-service")
public interface PatientProxy {
    @GetMapping("/patients")
    List<Patient> getAllPatients();

    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable("id") Integer id);

    @PutMapping("/patient/{id}/update")
    void updatePatient(@PathVariable("id") Integer id, PatientDto patientDto);

}
