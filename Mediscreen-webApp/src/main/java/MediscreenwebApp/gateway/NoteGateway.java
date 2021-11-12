package MediscreenwebApp.gateway;

import MediscreenwebApp.model.Note;
import MediscreenwebApp.model.Patient;
import lombok.SneakyThrows;
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
    public ResponseEntity<Note[]> getAllNotes() {
        return restTemplate.getForEntity("http://localhost:27018/note/getAll", Note[].class);
    }
}
