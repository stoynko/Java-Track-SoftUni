package softuni.exam.models.entity;

import jakarta.persistence.*;
import softuni.exam.models.entity.enums.*;

import java.util.*;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "vin", nullable = false, unique = true)
    private String vin;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "car_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CarType carType;

    @Column(name = "mileage", nullable = false)
    private int mileage;

    @Column(name = "model", nullable = false)
    private String model;

    @ManyToOne
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;

    @OneToMany(mappedBy = "offeringCar", targetEntity = Dealer.class)
    private List<Dealer> dealers;

    public Car() {
        this.dealers = new ArrayList<>();
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public void setDealers(List<Dealer> dealers) {
        this.dealers = dealers;
    }

    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getMileage() {
        return mileage;
    }

    public String getModel() {
        return model;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public List<Dealer> getDealers() {
        return dealers;
    }
}
