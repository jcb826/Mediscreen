package Mediscreenmsnotes.controller;

import Mediscreenmsnotes.model.Note;
import Mediscreenmsnotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("patHistory")
public class NotesController {


    @Autowired
    NoteService noteService;


    @PostMapping("/add")
    public Note addNote(@RequestBody @Valid Note note) {
        return noteService.createNote(note);
    }



    @GetMapping("/note")
    public Note getNoteById(@RequestParam(name = "id") String id) {
        return noteService.findNoteById(id);
    }

    @GetMapping("/notes")
    public List<Note> getNotesById(@RequestParam(name = "patientId") Long patientId) {
        return noteService.findNotesByPatientId(patientId);
    }
/*
@GetMapping("/notes/{patientId}")
    public List<Note> getNotesById(@PathVariable(name = "patientId") Long patientId) {
        return noteService.findNotesByPatientId(patientId);
    }
/*
    @PostMapping
    public void updatePatient(@RequestParam(name = "id") Integer id, @RequestBody Patient patient) {
        patientService.updatePatient(patient, id);
    }

    @DeleteMapping
    public void deletePatient(@RequestParam(name = "id") Integer id) {
        patientService.deletePatient(id);
    }


 */
    @GetMapping("/getAll")
    public List<Note> getAllNotes() {
        return noteService.findAllNotes();
    }



}
