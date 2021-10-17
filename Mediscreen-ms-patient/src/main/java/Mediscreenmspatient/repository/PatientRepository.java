package Mediscreenmspatient.repository;


import Mediscreenmspatient.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {


}
