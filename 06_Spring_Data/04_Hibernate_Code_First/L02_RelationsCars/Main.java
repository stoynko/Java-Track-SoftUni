import entities.*;
import jakarta.persistence.*;

import java.math.*;

public class Main {
/* Plate_number:
    •	Has an id - BigInteger
    •	Has a number – String
    •	Has a one to one relations with Cars

    Car:
	•	Has an id – long
	•	Has a fuelType – String
	•	Has a model – String
	•	Has a price – BigDecimal with precision (19,2)
	•	Has a type – String
	•	Has seats – int
	•	Has a one-to-one relationship with Plate_number via plateNumber_id */

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vehicle-jpa");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        LicensePlate licensePlateA = createLicensePlate("A 3910 BG");
        Car car = createCar(licensePlateA, "Mazda", "Hatchback", 4, "Gasoline", BigDecimal.valueOf(10000));

        entityManager.persist(car);
        entityManager.getTransaction().commit();
    }

    public static Car createCar (LicensePlate licensePlate, String model, String type, int seats, String fuelType, BigDecimal price) {
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setModel(model);
        car.setType(type);
        car.setSeats(seats);
        car.setFuelType(fuelType);
        car.setPrice(price);
        return car;
    }

    public static LicensePlate createLicensePlate (String number) {
        LicensePlate licensePlate = new LicensePlate();
        licensePlate.setNumber(number);
        return licensePlate;
    }
}