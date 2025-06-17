package entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "diagnoses")

public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code_classification")
    private String codeClassification;

    @Column(name = "clinical_classification")
    private String clinicalClassification;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "diagnoses", targetEntity = Examination.class)
    private List<Examination> examinations;

    public Diagnosis() {
        this.examinations = new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCodeClassification(String codeClassification) {
        this.codeClassification = codeClassification;
    }

    public void setClinicalClassification(String clinicalClassification) {
        this.clinicalClassification = clinicalClassification;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public long getId() {
        return id;
    }

    public String getCodeClassification() {
        return codeClassification;
    }

    public String getClinicalClassification() {
        return clinicalClassification;
    }

    public String getDescription() {
        return description;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }
}