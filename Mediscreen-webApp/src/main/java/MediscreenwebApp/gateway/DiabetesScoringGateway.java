package MediscreenwebApp.gateway;

import MediscreenwebApp.model.Patient;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class DiabetesScoringGateway {

    private final RestTemplate restTemplate;

    public DiabetesScoringGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SneakyThrows
    public ResponseEntity<String> getDiabetesScoringById(Integer id) {
        return restTemplate.getForEntity("http://localhost:8083/asses?id={id}", String.class,id.toString());
    }
}
