package MediscreenwebApp.controller;

import MediscreenwebApp.gateway.DiabetesScoringGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("asses")
public class DiabetesScoringController {

    private final DiabetesScoringGateway diabetesScoringGateway;

    public DiabetesScoringController(DiabetesScoringGateway diabetesScoringGateway) {
        this.diabetesScoringGateway = diabetesScoringGateway;
    }

    @GetMapping("/{patientId}")
    public String getAllNotesByPatientId(@PathVariable("patientId") Integer patientId, Model model) {
        model.addAttribute("scoring", diabetesScoringGateway.getDiabetesScoringById(patientId).getBody());

        return "diabetesScoring/scoring";
    }
}
