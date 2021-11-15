package Mediscreenmsnotes.repository;

import Mediscreenmsnotes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    public List<Note> findByPatientId(String  patientId);

}