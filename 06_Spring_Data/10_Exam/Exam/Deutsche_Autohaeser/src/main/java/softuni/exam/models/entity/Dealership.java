package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "dealerships")
public class Dealership extends BaseEntity {

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "dealership", targetEntity = Car.class)
    List<Car> cars;

    public Dealership() {
        this.cars = new ArrayList<>();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }
}
