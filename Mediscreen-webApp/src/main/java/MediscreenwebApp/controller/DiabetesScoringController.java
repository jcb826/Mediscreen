package MediscreenwebApp.controller;

import MediscreenwebApp.gateway.DiabetesScoringGateway;
import MediscreenwebApp.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("asses")
public class DiabetesScoringController {

    private final DiabetesScoringGateway diabetesScoringGateway;
    private final PatientService patientService;

    public DiabetesScoringController(DiabetesScoringGateway diabetesScoringGateway, PatientService patientService) {
        this.diabetesScoringGateway = diabetesScoringGateway;
        this.patientService = patientService;
    }

    @GetMapping("/{patientId}")
    public String getDiabetesScoringByPatientId(@PathVariable("patientId") Integer patientId, Model model) {
        model.addAttribute("scoring", diabetesScoringGateway.getDiabetesScoringById(patientId).getBody());
        model.addAttribute("patient", patientService.findPatientById(patientId));
        return "diabetesScoring/scoring";
    }
}
