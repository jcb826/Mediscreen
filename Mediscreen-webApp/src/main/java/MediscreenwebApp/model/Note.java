package MediscreenwebApp.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class Note {

    private String id;
    private Long patientId;
    private String note;
    private LocalDate noteDate;


    public Note() {
    }

    public Note(String id, Long patientId, String note, LocalDate noteDate) {
        this.id = id;
        this.patientId = patientId;
        this.note = note;
        this.noteDate = noteDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(LocalDate noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", patientId=" + patientId +
                ", note='" + note + '\'' +
                ", noteDate=" + noteDate +
                '}';
    }
}
