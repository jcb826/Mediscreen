package MediscreenwebApp.controller;


import MediscreenwebApp.model.Patient;
import MediscreenwebApp.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/add")
    public String addPatient(Patient patient) {
        //  logger.info("REQUEST: /bidList/add GET {} ");
        return "patient/add";
    }

    @PostMapping("/validate")
    public String validate(@Valid Patient patient, BindingResult result, Model model) {
        //  logger.info("REQUEST: /patient/validate POST  {} ", JsonStream.serialize(patient));
        if (!result.hasErrors()) {
            patientService.createPatient(patient);
            model.addAttribute("patients", patientService.findAllPatients());
            return "redirect:/patient/list";
        }
        return "patient/add";
    }

    @GetMapping("/list")
    public String getAllPatient(Model model) {
        model.addAttribute("patients", patientService.findAllPatients());
        return "patient/list";
    }


    @GetMapping("/update/{id}")
    public String showUpdatePatientForm(@PathVariable("id") Integer id, Model model) {
        //  logger.info("REQUEST: /user/update/{id} GET {} ");
        model.addAttribute("patient", patientService.findPatientById(id));
        return "patient/update.html";
    }


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


}
