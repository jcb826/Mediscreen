package Mediscreenmsdiabetesscoring.service;


import Mediscreenmsdiabetesscoring.gateway.NoteGateway;
import Mediscreenmsdiabetesscoring.gateway.PatientGateway;


import Mediscreenmsdiabetesscoring.model.Note;
import Mediscreenmsdiabetesscoring.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service("PatientService")
public class DiabetesScoringService {

    private final PatientGateway patientGateway;
    private final NoteGateway noteGateway;
    private ArrayList<String> keywords = new ArrayList<String>(
            Arrays.asList("Hémoglobine A1C,", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal", "Cholestérol",
                    "Vertige", "Rechute", "Réaction", "Anticorps"));


    public DiabetesScoringService(PatientGateway patientGateway, NoteGateway noteGateway) {
        this.patientGateway = patientGateway;
        this.noteGateway = noteGateway;
    }




    public String computeScoring(Integer patientId) {
        Patient patient = patientGateway.findPatientById(patientId).getBody();
        Integer age = computeAge(patient.getBirthday());
        String gender = patient.getGender();
        List<Note> allNotes = Arrays.stream(noteGateway.getAllNotesByPatientId(patientId).getBody()).toList();
       // count the numbers of keywords found in all notes
        int count = 0;
        for (Note note : allNotes) {
            for (String keyword : keywords) {
                if (note.getNote().toLowerCase().replaceAll(" ", "").contains(keyword.toLowerCase().replaceAll(" ", ""))) {
                    count++;
                    System.out.println(count);
                }
            }
        }
        if (count == 0) {
            return "diabetes scoring : None";
        }
        if (count==2 && age > 30) {
            return "diabetes scoring : Borderline";
        }
        if ((gender.contains("male")) && (age < 30) && (count == 3)) {
            return "diabetes scoring : in Danger";
        }
        if ((gender.contains("female")) && (age < 30) && (count == 4)) {
            return "diabetes scoring : in Danger";
        }
        if ((age >= 30) && (count == 6)) {
            return "diabetes scoring : in Danger";
        }
        if ((gender.contains("male")) && (age < 30) && (count == 5)) {
            return "diabetes scoring : Early onset";
        }
        if ((gender.contains("female")) && (age < 30) && (count == 7)) {
            return "diabetes scoring : Early onset";
        }
        if ( (age > 30) && (count >= 8)) {
            return "diabetes scoring : Early onset";
        }

        return "diabetes scoring : None";
    }

    public Integer computeAge(LocalDate birthDay) {
        LocalDate birthDate = LocalDate.of(birthDay.getYear(), birthDay.getMonth(), birthDay.getDayOfMonth());
        return Period.between(birthDate, LocalDate.now()).getYears();
    }




}