package entities;

import jakarta.persistence.*;

import java.math.*;
import java.util.*;

@Entity
@Table(name = "trucks")
public class Truck {

    /*Trucks:
	•	Has an id – BigInteger
	•	Has a fuel_type – String
	•	Has a model – String
	•	Has a price – BigDecimal(19,2)
	•	Has a type – String
	•	Has a load_capacity – double
	•	Has a many-to-many relationship with Drivers*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fuel_type")
    private String fuelType;

    @Basic
    private String model;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Basic
    private String type;

    @Column(name = "load_capacity")
    private double loadCapacity;

    @ManyToMany(mappedBy = "trucks", targetEntity = Driver.class)
    private List<Driver> drivers;

    public Truck() {
        this.drivers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
