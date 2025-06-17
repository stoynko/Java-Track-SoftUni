package main.java.F_SpringData.D_HibernateCodeFirst.L01_VehicleHierarchy.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "BIKE")
public class Bike extends Vehicle {

    public Bike() {
    }
}
