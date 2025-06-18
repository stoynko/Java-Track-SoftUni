package entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "PLANE")
public class Plane extends Vehicle {

    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    public Plane() {
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
