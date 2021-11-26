package MediscreenwebApp.service;


import MediscreenwebApp.gateway.NoteGateway;
import MediscreenwebApp.gateway.PatientGateway;


import MediscreenwebApp.model.Note;
import MediscreenwebApp.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("PatientService")
public class PatientService {

    private final PatientGateway patientGateway;
    private final NoteGateway noteGateway;
    private ArrayList<String> keywords = new ArrayList<String>(
            Arrays.asList("Hémoglobine A1C,", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal", "Cholestérol",
                    "Vertige", "Rechute", "Réaction", "Anticorps"));


    public PatientService(PatientGateway patientGateway, NoteGateway noteGateway) {
        this.patientGateway = patientGateway;
        this.noteGateway = noteGateway;
    }


    public Patient createPatient(Patient patient) {

        return patientGateway.createPatient(patient);
    }


    public List<Patient> findAllPatients() {

        return Arrays.stream(patientGateway.getAllPatients().getBody()).toList();

    }


    public Patient findPatientById(Integer id) {
        return patientGateway.findPatientById(id).getBody();
    }


    public Patient updatePatient(Patient patient, Integer id) {
        patient.setId(id);
        return patientGateway.createPatient(patient);
    }

    public void deletePatient(Integer id) {
        Patient patient = patientGateway.findPatientById(id).getBody();
        patientGateway.delete(patient.getId());
    }




}