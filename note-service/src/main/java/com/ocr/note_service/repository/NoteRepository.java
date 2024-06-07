package com.ocr.note_service.repository;

import com.ocr.note_service.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    Boolean existsByPatId(Integer id);

    List<Note> findByPatId(Integer id);

    Note findFirstByPatId(Integer id);

}
