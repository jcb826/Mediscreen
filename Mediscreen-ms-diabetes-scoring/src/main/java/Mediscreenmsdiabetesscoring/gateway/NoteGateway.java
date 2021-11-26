package Mediscreenmsdiabetesscoring.gateway;

import Mediscreenmsdiabetesscoring.model.Note;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NoteGateway {

    private final RestTemplate restTemplate;

    public NoteGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SneakyThrows
    public ResponseEntity<Note[]> getAllNotesByPatientId(Integer patientId) {
        return restTemplate.getForEntity("http://localhost:8082/patHistory/notes?patientId={patientId}", Note[].class,patientId);
    }

    @SneakyThrows
    public ResponseEntity<Note> addNote(Note note) {
        HttpEntity<Note> httpEntity = new HttpEntity<>(note);
        return restTemplate.postForEntity("http://localhost:8082/patHistory/add", httpEntity, Note.class);
    }

}
