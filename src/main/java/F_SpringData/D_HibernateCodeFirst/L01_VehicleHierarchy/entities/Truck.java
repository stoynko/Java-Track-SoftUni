package main.java.F_SpringData.D_HibernateCodeFirst.L01_VehicleHierarchy.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "TRUCK")
public class Truck extends Vehicle {

    @Column(name = "load_capacity")
    private double loadCapacity;

    public Truck() {
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
