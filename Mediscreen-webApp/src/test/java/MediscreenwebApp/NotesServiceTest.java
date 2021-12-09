package MediscreenwebApp;

import MediscreenwebApp.gateway.DiabetesScoringGateway;
import MediscreenwebApp.gateway.PatientGateway;
import MediscreenwebApp.model.Note;
import MediscreenwebApp.model.Patient;
import MediscreenwebApp.service.NoteService;
import MediscreenwebApp.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class NotesServiceTest {


    @Autowired
    NoteService noteService;
    @Autowired
    DiabetesScoringGateway diabetesScoringGateway;
    @Autowired
    PatientGateway patientGateway;

    @Test
    void contextLoads() {
    }

    @Test
    public void createNoteTest() {
        Note note = new Note(null, 50, "test", LocalDate.now());
        Note noteCreated = noteService.addNote(note);

        Assertions.assertEquals("test", noteCreated.getNote());

        noteService.deleteNote(noteCreated.getId());
    }

    @Test
    public void getAllNotesByPatientIdTest() {
        Note note2 = new Note(null, 51, "test", LocalDate.now());
        Note noteCreated2 = noteService.addNote(note2);

        Note note3 = new Note(null, 51, "test", LocalDate.now());
        Note noteCreated3 = noteService.addNote(note3);

        List<Note> notes = noteService.getAllNotesByPatientId(51).stream()
                .filter(note -> note.getNote().equals("test"))
                .collect(Collectors.toList());

        Assertions.assertEquals(2, notes.size());

        noteService.deleteNote(noteCreated2.getId());
        noteService.deleteNote(noteCreated3.getId());

    }
    @Test
    public void diabetesScoringTest() {
        // early  Onset patient less than 30  female 7 triggers
        LocalDate birthDay7 = LocalDate.of(2000, 05, 05);
      Patient patient7 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay7, "male", "test", "6666"));
        Note note7 = noteService.addNote(new Note(null, patient7.getId(), " Vertige Rechute coucou hello Hémoglobine A1C, Microalbumine Taille", LocalDate.now()));


    String scoring = diabetesScoringGateway.getDiabetesScoringById(patient7.getId()).getBody();



        Assertions.assertEquals("diabetes scoring : Early onset", scoring);

        noteService.deleteNote(note7.getId());
        patientGateway.delete(patient7.getId());


    }

}
