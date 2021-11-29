package Mediscreenmsdiabetesscoring;

import Mediscreenmsdiabetesscoring.gateway.NoteGateway;
import Mediscreenmsdiabetesscoring.gateway.PatientGateway;
import Mediscreenmsdiabetesscoring.model.Note;
import Mediscreenmsdiabetesscoring.model.Patient;
import Mediscreenmsdiabetesscoring.service.DiabetesScoringService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class DiabetesScoringServiceTest {

    @Autowired
    DiabetesScoringService diabetesScoringService;

    RestTemplate restTemplate = new RestTemplate();
    PatientGateway patientGateway = new PatientGateway(restTemplate);
    NoteGateway noteGateway = new NoteGateway(restTemplate);

    LocalDate birthDay = LocalDate.of(1980, 05, 05);
    private final Patient patient1 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay, "test", "test", "6666"));
    LocalDate now = LocalDate.now();
    private final Note note1 = noteGateway.addNote(new Note(null, patient1.getId(), " coucou hello ", now)).getBody();

    @Test
    void contextLoads() {
    }


    @Test
    void diabetesScoringServiceNoneResultTest() {
        String scoring = diabetesScoringService.computeScoring(patient1.getId());

        Assertions.assertEquals("diabetes scoring : None", scoring);

        patientGateway.delete(patient1.getId());
    }


}


