package Mediscreenmspatient;

import Mediscreenmspatient.model.Patient;
import Mediscreenmspatient.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PatientServiceTest {

	@Autowired
	PatientService patientService;
	LocalDate localDate = LocalDate.of(1980, 05, 05);
	private final Patient patient = new Patient(null, "test", "test", localDate, "test", "test", "6666");

	@Test
	void contextLoads() {
	}

	@Test
	public void createPatientTest() {
		Patient patientCreated = patientService.createPatient(patient);

		Assertions.assertEquals("6666", patientService.findPatientById(patientCreated.getId()).getPhone());
		patientService.deletePatient(patientCreated.getId());
	}

	@Test
	void findPatientByIdTest() {
		Patient patientCreated = patientService.createPatient(patient);

		Patient patient2 = patientService.findPatientById(patientCreated.getId());

		Assertions.assertEquals("6666", patient2.getPhone());
		patientService.deletePatient(patientCreated.getId());
	}

	@Test
	void updatePatientTest() {

		Patient patientCreated = patientService.createPatient(patient);
		patientCreated.setPhone("8888");

		Patient patientUpdated = patientService.updatePatient(patientCreated, patientCreated.getId());

		Assertions.assertEquals("8888", patientUpdated.getPhone());
		patientService.deletePatient(patientUpdated.getId());
	}

	@Test
	void deletePatientTest() {


		Patient patientCreated = patientService.createPatient(patient);
		patientService.deletePatient(patientCreated.getId());

		Assertions.assertEquals("6666", patientCreated.getPhone());

	}

	@Test
	void findAllPatientsTest() {


		Patient patientCreated = patientService.createPatient(patient);
		Patient patient2 = new Patient(null, "test", "test2", localDate, "test2", "test2", "6666");
		Patient patientCreated2 = patientService.createPatient(patient2);

		List<Patient> patients = patientService.findAllPatients();

		Assertions.assertEquals(2, patients.size());


	}


}