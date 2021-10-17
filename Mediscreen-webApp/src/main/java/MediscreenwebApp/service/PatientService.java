package MediscreenwebApp.service;


import MediscreenwebApp.gateway.PatientGateway;


import MediscreenwebApp.model.Patient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("PatientService")
public class PatientService {

    private final PatientGateway patientGateway;

    public PatientService(PatientGateway patientGateway) {
        this.patientGateway = patientGateway;
    }


    public Patient createPatient(Patient patient) {

        return  patientGateway.createPatient(patient);
    }


    public List<Patient> findAllPatients() {

        return Arrays.stream(patientGateway.getAllPatients().getBody()).toList();

    }

    public Patient findPatientById (Integer id){
        return patientGateway.findPatientById(id).getBody();
    }



    public Patient updatePatient(Patient patient, Integer id){
        patient.setId(id);
        return patientGateway.createPatient(patient);
    }

    public void deletePatient (Integer id){
        Patient patient = patientGateway.findPatientById(id).getBody();
        patientGateway.delete(patient.getId());
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