package com.ocr.note_service.repository;

import com.ocr.note_service.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {


    /**
     * Check if note exist with the patient id
     *
     * @param id the patient ID
     * @return true/false if note exist or not with the ID
     */
    Boolean existsByPatId(Integer id);

    /**
     * Find all notes with the patient ID
     *
     * @param id from patient ID
     * @return a list of notes associated with the given patient ID.
     */
    List<Note> findByPatId(Integer id);

    /**
     * Finds the first note associated with a given patient ID.
     *
     * @param id the patient ID to search for.
     * @return the first note associated with the given patient ID.
     */

    Note findFirstByPatId(Integer id);

}
