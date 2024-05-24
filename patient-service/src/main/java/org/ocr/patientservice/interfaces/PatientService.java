package org.ocr.patientservice.interfaces;

import org.ocr.patientservice.dto.PatientDto;
import org.ocr.patientservice.model.Patient;

import java.util.Optional;
import java.util.Set;

public interface PatientService {
     Set<Patient> index();
     Optional<Patient> findPatient(Integer id);
     Patient update(Integer id, PatientDto patientDto);
}
