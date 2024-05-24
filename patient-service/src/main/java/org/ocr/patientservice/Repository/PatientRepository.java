package org.ocr.patientservice.Repository;

import org.ocr.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
