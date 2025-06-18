import entities.*;
import jakarta.persistence.*;

import java.math.*;

public class Main {

/* Your task is to create a Vehicle hierarchy.
Vehicle - Abstract Class
    •	Has an Id – Long
    •	Has a Type - String
    •	Has a Model - String
    •	Has a Price - BigDecimal
    •	Has a fuelType - String

Car - Extends from the Vehicle class.
    •	Has Seats - Integer

Truck - Extends from the Vehicle class.
    •	Has loadCapacity - Double

Bike - Extends from the Vehicle class.

Plane - Extends from the Vehicle class.
    •	Has passengerCapacity - Integer */

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vehicle_hierarchy-jpa");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Car car = new Car();
        car.setSeats(2);
        car.setFuelType("Gasoline");
        car.setModel("Mazda");
        Plane plane = new Plane();
        plane.setPassengerCapacity(200);
        plane.setFuelType("Kerosene");
        plane.setPrice(BigDecimal.valueOf(100000));
        plane.setModel("X-Wing");
        Truck truck = new Truck();
        truck.setLoadCapacity(10000);
        truck.setFuelType("Diesel");
        Bike bike = new Bike();
        bike.setFuelType("Diesel");
        bike.setModel("Yamaha");

        entityManager.persist(car);
        entityManager.persist(truck);
        entityManager.persist(bike);
        entityManager.persist(plane);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}