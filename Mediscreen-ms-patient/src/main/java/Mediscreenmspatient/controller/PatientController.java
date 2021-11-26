package Mediscreenmspatient.controller;

import Mediscreenmspatient.model.Patient;
import Mediscreenmspatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/add")
    public Patient addPatient(@RequestBody @Valid Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping
    public Patient getPatientById(@RequestParam(name = "id") int id) {
        return this.patientService.findPatientById(id);
    }

    @PostMapping
    public void updatePatient(@RequestParam(name = "id") Integer id, @RequestBody Patient patient) {
        patientService.updatePatient(patient, id);
    }

    @DeleteMapping
    public void deletePatient(@RequestParam(name = "id") Integer id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/getAll")
    public List<Patient> patientsgetAllPatients() {
        return patientService.findAllPatients();
    }







    /*
    @RequestMapping("/user/list")
    public String home(Model model) {
        logger.info("REQUEST: /user/list GET {} ");
      //  model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User bid) {
        logger.info("REQUEST: /bidList/add GET {} ");
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        logger.info("REQUEST: /user/validate POST  {} ", JsonStream.serialize(user));
        if (!result.hasErrors()) {
            userService.addUser(user);
            model.addAttribute("users", userService.findAll());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        logger.info("REQUEST: /user/update/{id} GET {} ");
        model.addAttribute("user", userService.findById(id));
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
        logger.info("REQUEST: /user/update/{id} POST  {} ", JsonStream.serialize(user));
        if (result.hasErrors()) {
            return "user/update";
        }
        userService.updateUser(user, id);
        model.addAttribute("users", userService.findAll());
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        logger.info("REQUEST: /user/delete/{id} GET {} ");
        userService.deleteUser(id);
        model.addAttribute("users", userService.findAll());
        return "redirect:/user/list";
    }
     */


}
