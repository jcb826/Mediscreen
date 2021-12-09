package Mediscreenmsnotes.service;

import Mediscreenmsnotes.model.Note;
import Mediscreenmsnotes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NoteService")
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {

        return noteRepository.save(note);
    }


    public List<Note> findAllNotes() {

        return noteRepository.findAll();

    }

    public Note findNoteById(String id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));

    }

    public List<Note> findNotesByPatientId(Long id) {

        return noteRepository.findByPatientId(id);

    }


    public void deleteNote(Note note){
       noteRepository.delete(note);
    }




}
