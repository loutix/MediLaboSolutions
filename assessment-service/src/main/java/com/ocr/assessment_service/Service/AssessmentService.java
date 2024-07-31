package com.ocr.assessment_service.Service;

import com.ocr.assessment_service.bean.Note;
import com.ocr.assessment_service.bean.Risk;
import com.ocr.assessment_service.constants.Gender;
import com.ocr.assessment_service.constants.RiskEnum;

import java.util.List;

public interface AssessmentService {

    /**
     * Method to assess the risk level of a patient based on their notes and details.
     *
     * @param id patient ID
     * @return the assessed risk level of the patient composed of (Integer patientId, RiskEnum riskEnum).
     */
    Risk getPatientRisk(Integer id);

    /**
     * Method to count the number of keywords in a list of notes.
     *
     * @param noteList the list of notes to search for keywords.
     * @return the count of keywords found in the notes.
     */
    int countKeyword(List<Note> noteList);

    /**
     * Method to determine the risk level based on the count of keywords, gender, and age.
     *
     * @param nbr            the number of keywords found.
     * @param gender         the gender of the patient.
     * @param over30YearsOld boolean indicating if the patient is over 30 years old.
     * @return the determined risk level.
     */
    RiskEnum getRisk(int nbr, Gender gender, boolean over30YearsOld);

}
