package entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "BIKE")
public class Bike extends Vehicle {

    public Bike() {
    }
}
