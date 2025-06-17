package entities;

import entities.*;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "has_been_fulfilled")
    private boolean hasBeenFulfilled;

    @OneToOne(mappedBy = "prescription", targetEntity = Examination.class)
    private Examination examination;

    @ManyToMany
    @JoinTable(
            name = "prescriptions_medicaments",
            joinColumns = @JoinColumn(name = "prescription_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"))
    private List<Medicament> medicaments;

    public Prescription() { }

    public void setId(long id) {
        this.id = id;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    public long getId() {
        return id;
    }

    public Examination getExamination() {
        return examination;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }
}
