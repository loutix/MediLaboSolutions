package com.ocr.assessment_service.Service;

import com.ocr.assessment_service.bean.Note;
import com.ocr.assessment_service.bean.Patient;
import com.ocr.assessment_service.bean.Risk;
import com.ocr.assessment_service.constants.Gender;
import com.ocr.assessment_service.constants.Keyword;
import com.ocr.assessment_service.constants.RiskEnum;
import com.ocr.assessment_service.proxies.NoteProxy;
import com.ocr.assessment_service.proxies.PatientProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    private final NoteProxy noteProxy;
    private final PatientProxy patientProxy;


    public AssessmentService(NoteProxy noteProxy, PatientProxy patientProxy) {
        this.noteProxy = noteProxy;
        this.patientProxy = patientProxy;
    }

    /**
     * Method to get the list of notes by patient ID.
     *
     * @param id patient ID
     * @return a list of notes for the patient with the given ID.
     */
    public List<Note> showPatientNote(Integer id) {
        return noteProxy.getNoteByPatientId(id);
    }

    /**
     * Method to find a patient by their ID.
     *
     * @param id patient ID
     * @return the patient with the given ID.
     */
    public Patient showPatient(Integer id) {
        return patientProxy.getPatientId(id);
    }

    /**
     * Method to assess the risk level of a patient based on their notes and details.
     *
     * @param id patient ID
     * @return the assessed risk level of the patient composed of (Integer patientId, RiskEnum riskEnum).
     */
    public Risk getPatientRisk(Integer id) {

        List<Note> noteList = noteProxy.getNoteByPatientId(id);
        Patient patient = patientProxy.getPatientId(id);

        int nbr = this.countKeyword(noteList);

        if (nbr < 0) {
            return new Risk(patient.getId(), RiskEnum.None);
        } else {
            RiskEnum riskEnum = this.getRisk(nbr, patient.getGender(), patient.isOver30YearsOld());
            return new Risk(patient.getId(), riskEnum);
        }

    }

    /**
     * Method to count the number of keywords in a list of notes.
     *
     * @param noteList the list of notes to search for keywords.
     * @return the count of keywords found in the notes.
     */

    private int countKeyword(List<Note> noteList) {

        int count = 0;

        for (Note note : noteList) {
            for (String word : Keyword.getAllKeywords()) {
                if (note.getNote().toLowerCase().contains(word.toLowerCase())) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Method to determine the risk level based on the count of keywords, gender, and age.
     *
     * @param nbr            the number of keywords found.
     * @param gender         the gender of the patient.
     * @param over30YearsOld boolean indicating if the patient is over 30 years old.
     * @return the determined risk level.
     */
    private RiskEnum getRisk(int nbr, Gender gender, boolean over30YearsOld) {

        if (over30YearsOld) {

            if (nbr >= 2 && nbr <= 5) {
                return RiskEnum.Borderline;
            }
            if (nbr >= 6 && nbr <= 7) {
                return RiskEnum.InDanger;
            }
            if (nbr >= 8) {
                return RiskEnum.EarlyOnset;
            }
        }

        if (!over30YearsOld) {

            if (gender.equals(Gender.M)) {
                if (nbr >= 3 && nbr < 5) {
                    return RiskEnum.InDanger;
                } else if (nbr >= 5) {
                    return RiskEnum.EarlyOnset;
                }
            }

            if (gender.equals(Gender.F)) {
                if (nbr >= 4 && nbr < 7) {
                    return RiskEnum.InDanger;
                } else if (nbr >= 7) {
                    return RiskEnum.EarlyOnset;
                }
            }
        }

        return RiskEnum.None;
    }


}
