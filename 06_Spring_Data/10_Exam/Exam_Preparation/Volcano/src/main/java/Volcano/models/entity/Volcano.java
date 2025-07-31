package Volcano.models.entity;

import Volcano.models.enums.*;
import jakarta.persistence.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "volcanoes")
public class Volcano extends BaseEntity {

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "elevation", nullable = false)
    private Integer elevation;

    @Column(name = "last_eruption")
    private LocalDate lastEruption;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "volcano_type")
    @Enumerated(value = EnumType.STRING)
    private VolcanoType volcanoType;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "exploringVolcano", targetEntity = Volcanologist.class)
    private List<Volcanologist> volcanologists;

    public Volcano() { }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public void setLastEruption(LocalDate lastEruption) {
        this.lastEruption = lastEruption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolcanoType(VolcanoType volcanoType) {
        this.volcanoType = volcanoType;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setVolcanologists(List<Volcanologist> volcanologists) {
        this.volcanologists = volcanologists;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Integer getElevation() {
        return elevation;
    }

    public LocalDate getLastEruption() {
        return lastEruption;
    }

    public String getName() {
        return name;
    }

    public VolcanoType getVolcanoType() {
        return volcanoType;
    }

    public Country getCountry() {
        return country;
    }

    public List<Volcanologist> getVolcanologists() {
        return volcanologists;
    }
}
