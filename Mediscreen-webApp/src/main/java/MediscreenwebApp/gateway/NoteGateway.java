package MediscreenwebApp.gateway;

import MediscreenwebApp.model.Note;
import MediscreenwebApp.model.Patient;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.CacheRequest;
import java.util.UUID;

@Component
public class NoteGateway {

    private final RestTemplate restTemplate;

    public NoteGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SneakyThrows
    public ResponseEntity<Note[]> getAllNotesByPatientId(Long patientId) {
        return restTemplate.getForEntity("http://localhost:8082/patHistory/notes?patientId={patientId}", Note[].class,patientId);
    }




}
