package E02_Car_Dealer.data.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "travelled_distance", nullable = false)
    private Long travelledDistance;

    @ManyToMany
    @JoinTable(name = "cars_parts",
    joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    private List<Part> partsList;

    public Car() {
        this.partsList = new ArrayList<>();
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setPartsList(List<Part> partsList) {
        this.partsList = partsList;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public List<Part> getPartsList() {
        return partsList;
    }
}
