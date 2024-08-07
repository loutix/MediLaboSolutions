package org.ocr.patientservice.service;

import lombok.extern.slf4j.Slf4j;
import org.ocr.patientservice.Exception.PatientNotFoundException;
import org.ocr.patientservice.Repository.PatientRepository;
import org.ocr.patientservice.dto.PatientDto;
import org.ocr.patientservice.model.Patient;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Retrieves a list sorted by ID of all patients from DB
     *
     * @return a sorted list of patients
     */
    @Override
    public List<Patient> index() {
        List<Patient> patientList = patientRepository.findAll();
        patientList.sort(Comparator.comparingInt(Patient::getId));
        return patientList;
    }


    /**
     * @param id from patient
     * @return patient or null
     */
    @Override
    public Optional<Patient> findPatient(Integer id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            throw new PatientNotFoundException(id);
        }
        return patient;
    }


    /**
     * @param id         the id From patient to updated
     * @param patientDto PatientDto
     * @return method return the patient updated
     */
    @Override
    public Patient update(Integer id, PatientDto patientDto) {
        Optional<Patient> patient = patientRepository.findById(id).stream().findFirst();
        if (patient.isEmpty()) {
            throw new PatientNotFoundException(id);
        }

        Patient patientToUpdate = patient.get();
        patientToUpdate.setFirst_name(patientDto.getFirst_name());
        patientToUpdate.setLast_name(patientDto.getLast_name());
        patientToUpdate.setBirth_date(patientDto.getBirth_date());
        patientToUpdate.setGender(patientDto.getGender());
        patientToUpdate.setAddress(patientDto.getAddress());
        patientToUpdate.setPhone(patientDto.getPhone());

        patientRepository.save(patientToUpdate);

        return patientToUpdate;
    }

}
