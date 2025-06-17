import entities.*;
import jakarta.persistence.*;

import java.math.*;
import java.util.*;

public class Main {

/* Drivers
    •	Has an id - BigInteger
    •	Has a full_name - String
    •	Has many to many relations with Cars
Trucks:
	•	Has an id – BigInteger
	•	Has a fuel_type – String
	•	Has a model – String
	•	Has a price – BigDecimal(19,2)
	•	Has a type – String
	•	Has a load_capacity – double
	•	Has a many-to-many relationship with Drivers

A truck can be operated by several drivers, depending on schedules or licenses. */

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vehicle-jpa");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Driver> drivers = registerDrivers();
        drivers.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Driver> registerDrivers() {
        Driver driverA = createDriver("James Morgan");
        Driver driverB = createDriver("Elena Rivers");
        Driver driverC = createDriver("Carlos Mendoza");
        Driver driverD = createDriver("Linda Chen");
        Driver driverE = createDriver("Igor Petrov");
        return List.of(driverA, driverB, driverC, driverD, driverE);
    }

    public static Truck buildTruck(String fuelType, String model, String type, BigDecimal price, double capacity) {
        Truck truck = new Truck();
        truck.setFuelType(fuelType);
        truck.setModel(model);
        truck.setType(type);
        truck.setPrice(price);
        truck.setLoadCapacity(capacity);
        return truck;
    }

    public static Driver createDriver(String fullName) {
        Driver driver = new Driver();
        driver.setFullName(fullName);
        List<Truck> assignedTrucks = assignTrucks(driver);
        driver.setTrucks(assignedTrucks);
        return driver;
    }

    public static List<Truck> assignTrucks(Driver driver) {
        List<Truck> truckList = new ArrayList<>();

        switch (driver.getFullName()) {
            case "James Morgan" -> {
                Truck truck1 = buildTruck("Diesel", "Volvo FH16", "Heavy Duty", BigDecimal.valueOf(180000.00), 44.0);
                Truck truck2 = buildTruck("Diesel", "Scania R Series", "Flatbed", BigDecimal.valueOf(160000.00), 35.0);
                truck1.getDrivers().add(driver);
                truck2.getDrivers().add(driver);
                truckList = List.of(truck1, truck2);
            }
            case "Elena Rivers" -> {
                Truck truck1 = buildTruck("Electric", "Tesla Semi", "Box", BigDecimal.valueOf(200000.00), 36.0);
                Truck truck2 = buildTruck("Diesel", "Mercedes Actros", "Refrigerated", BigDecimal.valueOf(170000.00), 32.5);
                truck1.getDrivers().add(driver);
                truck2.getDrivers().add(driver);
                truckList = List.of(truck1, truck2);
            }
            case "Carlos Mendoza" -> {
                Truck truck1 = buildTruck("Diesel", "MAN TGX", "Tanker", BigDecimal.valueOf(155000.00), 30.0);
                Truck truck2 = buildTruck("Diesel", "Iveco S-Way", "Curtain Side", BigDecimal.valueOf(145000.00), 28.0);
                truck1.getDrivers().add(driver);
                truck2.getDrivers().add(driver);
                truckList = List.of(truck1, truck2);
            }
            case "Linda Chen" -> {
                Truck truck1 = buildTruck("Diesel", "DAF XF", "Box", BigDecimal.valueOf(158000.00), 33.0);
                Truck truck2 = buildTruck("Diesel", "Kenworth T680", "Refrigerated", BigDecimal.valueOf(168000.00), 34.0);
                truck1.getDrivers().add(driver);
                truck2.getDrivers().add(driver);
                truckList = List.of(truck1, truck2);
            }
            case "Igor Petrov" -> {
                Truck truck1 = buildTruck("Diesel", "Peterbilt 579", "Flatbed", BigDecimal.valueOf(165000.00), 38.0);
                Truck truck2 = buildTruck("Diesel", "Freightliner Cascadia", "Box", BigDecimal.valueOf(162000.00), 40.0);
                truck1.getDrivers().add(driver);
                truck2.getDrivers().add(driver);
                truckList = List.of(truck1, truck2);
            }
        }

        return truckList;
    }
}