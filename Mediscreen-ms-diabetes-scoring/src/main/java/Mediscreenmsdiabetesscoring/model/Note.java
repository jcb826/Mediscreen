package Mediscreenmsdiabetesscoring.model;

import java.time.LocalDate;

public class Note {

    private String id;
    private Integer patientId;
    private String note;
    private LocalDate noteDate;


    public Note() {
    }

    public Note(String id, Integer patientId, String note, LocalDate noteDate) {
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

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
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
