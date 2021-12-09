package MediscreenwebApp.controller;

import MediscreenwebApp.model.Note;
import MediscreenwebApp.service.NoteService;
import MediscreenwebApp.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;


@Controller
@RequestMapping("notes")
public class NotesController {

    private final NoteService notesService;
    private final PatientService patientService;


    public NotesController(NoteService notesService, PatientService patientService) {
        this.notesService = notesService;
        this.patientService = patientService;

    }



    @GetMapping("/add/{patientId}")
    public String addNote(@PathVariable("patientId") Long patientId, Model model,Note note) {
        //  logger.info("REQUEST: /bidList/add GET {} ");
        model.addAttribute("patientId", patientId);
        return "notes/add";
    }




        @PostMapping("/validate")
        public String validate(@Valid Note note, BindingResult result, Model model) {

            if (!result.hasErrors()) {
                note.setNoteDate(LocalDate.now());
                notesService.addNote(note);
                model.addAttribute("notes", notesService.getAllNotesByPatientId(note.getPatientId()));
                return "redirect:/notes/list/" + note.getPatientId();
            }
            return "patient/add";
        }



    @GetMapping("/list/{patientId}")
    public String getAllNotesByPatientId(@PathVariable("patientId") Integer patientId, Model model) {
        model.addAttribute("notes", notesService.getAllNotesByPatientId(patientId));
        model.addAttribute("patientId", patientId);
        return "notes/list";
    }



/*
        @GetMapping("/update/{id}")
        public String showUpdatePatientForm(@PathVariable("id") Integer id, Model model) {
            //  logger.info("REQUEST: /user/update/{id} GET {} ");
            model.addAttribute("patient", patientService.findPatientById(id));
            return "patient/update.html";
        }
        /*


        @PostMapping("/update/{id}")
        public String updateUser(@PathVariable("id") Integer id, @Valid Patient patient,
                                 BindingResult result, Model model) {
            //  logger.info("REQUEST: /user/update/{id} POST  {} ", JsonStream.serialize(user));
            if (result.hasErrors()) {
                return "patient/update";
            }
            patientService.updatePatient(patient, id);
            // model.addAttribute("patients",patientService.findAllPatients());
            return "redirect:/patient/list";
        }


        @GetMapping("/delete/{id}")
        public String deleteUser(@PathVariable("id") Integer id, Model model) {
            // logger.info("REQUEST: /user/delete/{id} GET {} ");
            patientService.deletePatient(id);
            model.addAttribute("users", patientService.findAllPatients());
            return "redirect:/patient/list";
        }

 */
}
