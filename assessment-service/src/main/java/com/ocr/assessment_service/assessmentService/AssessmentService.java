package com.ocr.assessment_service.assessmentService;

import com.ocr.assessment_service.bean.Note;
import com.ocr.assessment_service.proxies.NoteProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    private final NoteProxy noteProxy;

    public AssessmentService(NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    public List<Note> showPatientNote(Integer id) {

        return noteProxy.getNoteByPatientId(id);
    }
}
