package entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "medicaments")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "medicaments", targetEntity = Prescription.class)
    private List<Prescription> prescriptions;

    public Medicament() { }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
