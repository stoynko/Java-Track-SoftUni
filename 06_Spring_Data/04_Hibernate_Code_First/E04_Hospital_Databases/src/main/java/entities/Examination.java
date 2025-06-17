package entities;

import jakarta.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "examinations")
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private Instant date;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToMany
    @JoinTable(name = "examinations_diagnoses",
            joinColumns = @JoinColumn(name = "examination_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"))
    private Set<Diagnosis> diagnoses;

    @OneToOne(optional = true)
    @JoinColumn(name = "prescription_id", referencedColumnName = "id")
    private Prescription prescription;

    public Examination() { }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public long getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public String getComments() {
        return comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Set<Diagnosis> getDiagnoses() {
        return Collections.unmodifiableSet(diagnoses);
    }

    public Prescription getPrescription() {
        return prescription;
    }
}
