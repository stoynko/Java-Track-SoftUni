package entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "doctors")
public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "doctor", targetEntity = Examination.class)
    private List<Examination> examinations;

    public Doctor() {
        super();
        this.examinations = new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public long getId() {
        return id;
    }

    public List<Examination> getExaminations() {
        return Collections.unmodifiableList(examinations);
    }
}
