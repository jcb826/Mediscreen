package MediscreenwebApp.service;

import MediscreenwebApp.gateway.NoteGateway;
import MediscreenwebApp.model.Note;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("NoteService")
public class NotesService {

    private final NoteGateway noteGateway;

    public NotesService(NoteGateway patientGateway, NoteGateway noteGateway) {
        this.noteGateway = noteGateway;

    }


    public List<Note> getAllNotesByPatientId(Long patientId) {
        return Arrays.stream(noteGateway.getAllNotesByPatientId(patientId).getBody()).toList();
    }
}
