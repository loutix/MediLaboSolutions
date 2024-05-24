package org.ocr.patientservice.service;

import lombok.extern.slf4j.Slf4j;
import org.ocr.patientservice.Exception.PatientNotFoundException;
import org.ocr.patientservice.Repository.PatientRepository;
import org.ocr.patientservice.dto.PatientDto;
import org.ocr.patientservice.interfaces.PatientService;
import org.ocr.patientservice.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Return all patients
     *
     * @return Set<Patient>
     */
    @Override
    public Set<Patient> index() {
        return new HashSet<>(patientRepository.findAll());
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
     * @param id         Integer
     * @param patientDto PatientDto
     * @return the method return the patient updated
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
