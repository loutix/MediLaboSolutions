package com.ocr.assessment_service.Service;

import com.ocr.assessment_service.bean.Note;
import com.ocr.assessment_service.bean.Patient;
import com.ocr.assessment_service.constants.Gender;
import com.ocr.assessment_service.constants.Keyword;
import com.ocr.assessment_service.bean.Risk;
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

    public List<Note> showPatientNote(Integer id) {
        return noteProxy.getNoteByPatientId(id);
    }

    public Patient showPatient(Integer id) {
        return patientProxy.getPatientId(id);
    }

    public Risk getPatientRisk(Integer id) {

        List<Note> noteList = noteProxy.getNoteByPatientId(id);
        Patient patient = patientProxy.getPatientId(id);

        int nbr = this.countKeyword(noteList);

        if (nbr < 0) {
            return new Risk(patient.getId(), com.ocr.assessment_service.constants.Risk.None);
        } else {
            com.ocr.assessment_service.constants.Risk risk = this.getRisk(nbr, patient.getGender(), patient.isOver30YearsOld());
            return new Risk(patient.getId(), risk);
        }

    }


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


    private com.ocr.assessment_service.constants.Risk getRisk(int nbr, Gender gender, boolean over30YearsOld) {

        if (over30YearsOld) {

            if (nbr >= 2 && nbr <= 5) {
                return com.ocr.assessment_service.constants.Risk.Borderline;
            }
            if (nbr >= 6 && nbr <= 7) {
                return com.ocr.assessment_service.constants.Risk.InDanger;
            }
            if (nbr >= 8) {
                return com.ocr.assessment_service.constants.Risk.EarlyOnset;
            }
        }

        if (!over30YearsOld) {

            if (gender.equals(Gender.M)) {
                if (nbr >= 3 && nbr < 5) {
                    return com.ocr.assessment_service.constants.Risk.InDanger;
                } else if (nbr >= 5) {
                    return com.ocr.assessment_service.constants.Risk.EarlyOnset;
                }
            }

            if (gender.equals(Gender.F)) {
                if (nbr >= 4 && nbr < 7) {
                    return com.ocr.assessment_service.constants.Risk.InDanger;
                } else if (nbr >= 7) {
                    return com.ocr.assessment_service.constants.Risk.EarlyOnset;
                }
            }
        }

        return com.ocr.assessment_service.constants.Risk.None;
    }


}
