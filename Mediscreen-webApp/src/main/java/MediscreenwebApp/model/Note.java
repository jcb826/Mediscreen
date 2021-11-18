package MediscreenwebApp.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class Note {

    public String id;
    public Long patientId;
    public String note;
}
