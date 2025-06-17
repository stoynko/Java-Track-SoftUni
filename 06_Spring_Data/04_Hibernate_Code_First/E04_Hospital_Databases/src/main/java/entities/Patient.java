package entities;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "patients")
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String picture;

    @Column(name = "has_insurance")
    private boolean hasInsurance;

    @OneToMany(mappedBy = "patient", targetEntity = Examination.class, cascade = CascadeType.ALL)
    private List<Examination> examinations;

    public Patient() {
        super();
        this.examinations = new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public long getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public List<Examination> getExaminations() {
        return Collections.unmodifiableList(examinations);
    }
}
