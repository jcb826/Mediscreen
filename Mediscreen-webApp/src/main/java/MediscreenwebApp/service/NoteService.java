package MediscreenwebApp.service;

import MediscreenwebApp.gateway.NoteGateway;
import MediscreenwebApp.model.Note;
import MediscreenwebApp.model.Patient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("NoteService")
public class NoteService {

    private final NoteGateway noteGateway;


    public NoteService(NoteGateway patientGateway, NoteGateway noteGateway, PatientService patientService) {
        this.noteGateway = noteGateway;


    }


    public List<Note> getAllNotesByPatientId(Integer patientId) {
        return Arrays.stream(noteGateway.getAllNotesByPatientId(patientId).getBody()).toList();
    }

    public Note addNote(Note note) {
        return noteGateway.addNote(note).getBody();
    }

    public void deleteNote(String id) {

        noteGateway.delete(id);
    }

}
