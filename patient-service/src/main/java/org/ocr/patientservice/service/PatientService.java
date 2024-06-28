package org.ocr.patientservice.service;

import org.ocr.patientservice.dto.PatientDto;
import org.ocr.patientservice.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    /**
     * Retrieves a list of all patients.
     *
     * @return a list of patients.
     */
    List<Patient> index();


    /**
     * Finds a patient by their ID.
     *
     * @param id the ID of the patient to find
     * @return an Optional containing the found patient, or empty if not found.
     */
    Optional<Patient> findPatient(Integer id);

    /**
     * Updates a patient's information.
     *
     * @param id         the ID of the patient to update.
     * @param patientDto the data transfer object containing updated patient information.
     * @return the updated patient.
     */
    Patient update(Integer id, PatientDto patientDto);

}
