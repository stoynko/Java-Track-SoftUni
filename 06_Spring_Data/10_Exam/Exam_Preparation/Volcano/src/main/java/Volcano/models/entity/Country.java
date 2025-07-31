package Volcano.models.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column(name = "capital")
    private String capital;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", targetEntity = Volcano.class)
    private List<Volcano> volcanoes;

    public Country() { }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }
}
