package Mediscreenmspatient.service;


import Mediscreenmspatient.model.Patient;
import Mediscreenmspatient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PatientService")
public class PatientService {

    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {

        return patientRepository.save(patient);
    }

    public List<Patient> findAllPatients() {
        Iterable<Patient> patients = patientRepository.findAll();
        List<Patient> result = new ArrayList<>();
        patients.forEach(result::add);
        return result;

    }

    public Patient findPatientById(Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
    }

    public Patient updatePatient(Patient patient, Integer id) {
        patient.setId(id);
        return patientRepository.save(patient);
    }
    public void deletePatient(Integer id){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        patientRepository.delete(patient);
    }

}