package entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "CAR")
public class Car extends Vehicle {

    @Column(name = "seats")
    private int seats;

    public Car() {
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
