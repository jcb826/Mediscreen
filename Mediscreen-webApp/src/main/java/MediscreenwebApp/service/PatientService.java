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
    ArrayList<String> keywords = new ArrayList<String>(
            Arrays.asList("Hémoglobine A1C,","Microalbumine","Taille","Poids","Fumeur","Anormal","Cholestérol",
            "Vertige","Rechute","Réaction","Anticorps"));



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

    public String computeScoring(Integer patientId) {
        Patient patient = findPatientById(patientId);
        Integer age = computeAge(patient.getBirthday());
        String gender = patient.getGender();
       List<Note> allNotes = Arrays.stream(noteGateway.getAllNotesByPatientId(patientId).getBody()).toList();

       int count =0;
        for (Note note : allNotes) {
            for (String keyword : keywords) {
                if (note.getNote().toLowerCase().contains(keyword.toLowerCase())){
                   count++;
                    System.out.println(count);
                }

            }


        }

        return null;
    }

    public Integer computeAge(LocalDate birthDay) {
        LocalDate birthDate = LocalDate.of(birthDay.getYear(), birthDay.getMonth(), birthDay.getDayOfMonth());

        return Period.between(birthDate, LocalDate.now()).getYears();
    }


      /*
        public List<Patient> findAllPatients() {
            Iterable<Patient> patients = patientRepository.findAll();
            List<Patient> result = new ArrayList<>();
            patients.forEach(result::add);
            return result;

        }

     */

}