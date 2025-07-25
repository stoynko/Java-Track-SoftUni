package E02_Car_Dealer.data.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity(name = "cars")
public class Car extends BaseEntity {

    private String make;

    private String model;

    @Column(name = "travelled_distance")
    private double travelledDistance;

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

    public void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getTravelledDistance() {
        return travelledDistance;
    }
}
