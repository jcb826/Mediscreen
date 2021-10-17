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

    @GetMapping("/getAll")
    public List<Note> getAllNotes() {
        return noteService.findAllNotes();
    }

}
