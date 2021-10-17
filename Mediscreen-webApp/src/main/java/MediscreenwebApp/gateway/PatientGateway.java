package MediscreenwebApp.gateway;

import MediscreenwebApp.model.Patient;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientGateway {

    private final RestTemplate restTemplate;


    public PatientGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SneakyThrows
    public ResponseEntity<Patient[]> getAllPatients() {
        return restTemplate.getForEntity("http://localhost:8081/patient/getAll", Patient[].class);
    }

    @SneakyThrows
    public Patient createPatient(Patient patient) {
        HttpEntity<Patient> httpEntity= new HttpEntity<>(patient);
        return   restTemplate.postForEntity("http://localhost:8081/patient/add",httpEntity, Patient.class ).getBody();
    }
    @SneakyThrows
    public ResponseEntity<Patient> findPatientById(Integer id) {
        return restTemplate.getForEntity("http://localhost:8081/patient?id={id}", Patient.class,id.toString());
    }

    @SneakyThrows
    public void delete(Integer id) {
        restTemplate.delete("http://localhost:8081/patient?id={id}",id.toString());
    }


}