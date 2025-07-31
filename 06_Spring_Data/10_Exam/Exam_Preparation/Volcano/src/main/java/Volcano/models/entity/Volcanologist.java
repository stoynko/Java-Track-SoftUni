package Volcano.models.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "volcanologists")
public class Volcanologist extends BaseEntity{

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "exploring_from")
    private LocalDate exploringFrom;

    @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "exploring_volcano_id")
    private Volcano exploringVolcano;

    public Volcanologist() { }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setExploringFrom(LocalDate exploringFrom) {
        this.exploringFrom = exploringFrom;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setExploringVolcano(Volcano exploringVolcano) {
        this.exploringVolcano = exploringVolcano;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getExploringFrom() {
        return exploringFrom;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public Volcano getExploringVolcano() {
        return exploringVolcano;
    }
}
