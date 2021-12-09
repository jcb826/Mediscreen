package Mediscreenmsnotes;

import Mediscreenmsnotes.model.Note;
import Mediscreenmsnotes.service.NoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class NoteServiceTest {


    @Autowired
    NoteService noteService;

    @Test
    void contextLoads() {
    }

    @Test
    public void createNoteTest() {
        Note note = new Note(null, 50l, "test", LocalDate.now());
        Note noteCreated = noteService.createNote(note);

        Assertions.assertEquals("test", noteCreated.getNote());
        noteService.deleteNote(noteCreated);
    }

    @Test
    void findAllNotesTest() {
        Note note1 = new Note(null, 51l, "test", LocalDate.now());
        Note noteCreated1 = noteService.createNote(note1);
        Note note2 = new Note(null, 52l, "test", LocalDate.now());
        Note noteCreated2 = noteService.createNote(note2);


        List<Note> notes = noteService.findAllNotes().stream()
                .filter(note -> note.getNote().equals("test"))
                .collect(Collectors.toList());


        Assertions.assertEquals(2, notes.size());

        noteService.deleteNote(noteCreated1);
        noteService.deleteNote(noteCreated2);
    }

    @Test
    void findNoteByIdTest() {

        Note note3 = new Note(null, 55l, "test3", LocalDate.now());
        Note noteCreated3 = noteService.createNote(note3);

        Note result = noteService.findNoteById(noteCreated3.getId());

        Assertions.assertEquals("test3",result.getNote());

        noteService.deleteNote(noteCreated3);

    }

    @Test
    void findAllNoteByPatientIdTest() {

        Note note4 = new Note(null, 300l, "test", LocalDate.now());
        Note noteCreated4 = noteService.createNote(note4);
        Note note5 = new Note(null, 300l, "test", LocalDate.now());
        Note noteCreated5 = noteService.createNote(note5);

        List<Note> notes2 = noteService.findNotesByPatientId(300l);

        Assertions.assertEquals(2, notes2.size());

        noteService.deleteNote(noteCreated4);
        noteService.deleteNote(noteCreated5);

    }


}


