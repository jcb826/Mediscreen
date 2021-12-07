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
    // none  patient
    LocalDate birthDay = LocalDate.of(1980, 05, 05);
    private final Patient patient1 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay, "male", "test", "6666"));
    LocalDate now = LocalDate.now();
    private final Note note1 = noteGateway.addNote(new Note(null, patient1.getId(), " coucou hello ", now)).getBody();

    // Bordeline   patient
    LocalDate birthDay2 = LocalDate.of(1980, 05, 05);
    private final Patient patient2 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay2, "male", "test", "6666"));
    private final Note note2 = noteGateway.addNote(new Note(null, patient2.getId(), " coucou hello Hémoglobine A1C, Microalbumine ", now)).getBody();
    // In danger   patient male less than 30 3 triggers
    LocalDate birthDay3 = LocalDate.of(2000, 05, 05);
    private final Patient patient3 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay3, "male", "test", "6666"));
    private final Note note3 = noteGateway.addNote(new Note(null, patient3.getId(), " coucou hello Hémoglobine A1C, Microalbumine Taille", now)).getBody();

    // In danger   patient female less than 30 4 triggers
    LocalDate birthDay4 = LocalDate.of(2000, 05, 05);
    private final Patient patient4 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay4, "female", "test", "6666"));
    private final Note note4 = noteGateway.addNote(new Note(null, patient4.getId(), " coucou hello Hémoglobine A1C, Microalbumine Taille Poids", now)).getBody();

    // In danger   patient more than 30 6 triggers
    LocalDate birthDay5 = LocalDate.of(1980, 05, 05);
    private final Patient patient5 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay5, "female", "test", "6666"));
    private final Note note5 = noteGateway.addNote(new Note(null, patient5.getId(), " Vertige Rechute coucou hello Hémoglobine A1C, Microalbumine Taille Poids", now)).getBody();

    // early  Onset patient less than 30  male 5 triggers
    LocalDate birthDay6 = LocalDate.of(2000, 05, 05);
    private final Patient patient6 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay6, "male", "test", "6666"));
    private final Note note6 = noteGateway.addNote(new Note(null, patient6.getId(), " Vertige Rechute coucou hello Hémoglobine A1C, Microalbumine Taille", now)).getBody();

    // early  Onset patient less than 30  female 7 triggers
    LocalDate birthDay7 = LocalDate.of(2000, 05, 05);
    private final Patient patient7 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay7, "male", "test", "6666"));
    private final Note note7 = noteGateway.addNote(new Note(null, patient7.getId(), " Vertige Rechute coucou hello Hémoglobine A1C, Microalbumine Taille", now)).getBody();

    // early  Onset patient more than 30   8 or more triggers
    LocalDate birthDay8 = LocalDate.of(1980, 05, 05);
    private final Patient patient8 = patientGateway.createPatient(new Patient(null, "test", "test", birthDay8, "male", "test", "6666"));
    private final Note note8 = noteGateway.addNote(new Note(null, patient8.getId(), " Vertige Rechute coucou hello Hémoglobine A1C, Microalbumine Taille Poids Fumeur Anormal", now)).getBody();


    @Test
    void contextLoads() {
    }


    @Test
    void diabetesScoringServiceNoneResultTest() {
        String scoring = diabetesScoringService.computeScoring(patient1.getId());

        Assertions.assertEquals("diabetes scoring : None", scoring);

        patientGateway.delete(patient1.getId());

    }

    @Test
    void diabetesScoringServiceBorderlineResultTest() {
        String scoring = diabetesScoringService.computeScoring(patient2.getId());

        Assertions.assertEquals("diabetes scoring : Borderline", scoring);

        patientGateway.delete(patient2.getId());
    }

    @Test
    void diabetesScoringServiceInDangerResultMaleTest() {
        String scoring = diabetesScoringService.computeScoring(patient3.getId());

        Assertions.assertEquals("diabetes scoring : in Danger", scoring);

        patientGateway.delete(patient3.getId());
    }

    @Test
    void diabetesScoringServiceInDangerResultFemaleTest() {
        String scoring = diabetesScoringService.computeScoring(patient4.getId());

        Assertions.assertEquals("diabetes scoring : in Danger", scoring);

        patientGateway.delete(patient4.getId());
    }

    @Test
    void diabetesScoringServiceInDangerResult6TriggersTest() {
        String scoring = diabetesScoringService.computeScoring(patient5.getId());

        Assertions.assertEquals("diabetes scoring : in Danger", scoring);

        patientGateway.delete(patient5.getId());
    }

    @Test
    void diabetesScoringServiceInDangerResultMale5TriggersTest() {
        String scoring = diabetesScoringService.computeScoring(patient6.getId());

        Assertions.assertEquals("diabetes scoring : Early onset", scoring);

        patientGateway.delete(patient6.getId());
    }

    @Test
    void diabetesScoringServiceInDangerResultFeMale7TriggersTest() {
        String scoring = diabetesScoringService.computeScoring(patient7.getId());

        Assertions.assertEquals("diabetes scoring : Early onset", scoring);

        patientGateway.delete(patient7.getId());
    }

    @Test
    void diabetesScoringServiceInDangerResultMorethan30And8TriggersTest() {
        String scoring = diabetesScoringService.computeScoring(patient8.getId());

        Assertions.assertEquals("diabetes scoring : Early onset", scoring);

        patientGateway.delete(patient8.getId());
    }

}


