package com.ocr.client_service.proxies;

import com.ocr.client_service.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patient-service", url = "localhost:8080")
public interface PatientProxy {
    @GetMapping("patient-service/patients")
    List<Patient> getAllPatients();

    @GetMapping("patient-service/show/{id}")
    Patient getPatient(@PathVariable("id") Integer id);
}
