package Mediscreenmsdiabetesscoring.controller;

import Mediscreenmsdiabetesscoring.service.DiabetesScoringService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("asses")
public class PatientController {

    @Autowired
    DiabetesScoringService diabetesScoringService;




    @GetMapping
    public String getDiabetesScoringById(@RequestParam(name = "id") int id) {
        return this.diabetesScoringService.computeScoring(id);
    }












}
