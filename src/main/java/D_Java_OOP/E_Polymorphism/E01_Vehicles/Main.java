package D_Java_OOP.E_Polymorphism.E01_Vehicles;

import java.util.*;

public class Main {

    /*Write a program that models 2 vehicles (Car and Truck) and will be able to simulate driving and refueling them in the summer. Car and truck both have fuel quantity,
    and fuel consumption in liters per km and can be driven given distance and refueled with given liters.
    But in the summer both vehicles use the air conditioner and their fuel consumption per km is increased by 0.9 liters for the car and 1.6 liters for the truck.
    Also, the truck has a tiny hole in its tank and when it gets refueled it gets only 95% of the given fuel. The car has no problems when refueling and adds all given fuel to its tank.
    If the vehicle cannot travel a given distance its fuel does not change.

    Input
        •	On the first line - information about the car in format "Car {fuel quantity} {liters per km}".
        •	On the second line – info about the truck in the format "Truck {fuel quantity} {liters per km}".
        •	On the third line - a number of commands N will be given on the next N lines.
        •	On the next N lines – commands in the format:
            o	Drive Car {distance}
            o	Drive Truck {distance}
            o	Refuel Car {liters}
            o	Refuel Truck {liters}

    Output:
    After each Drive command print whether the Car/Truck was able to travel a given distance in format if it’s successful.
    Print the distance with two digits after the decimal separator except for trailing zeros. Use the DecimalFormat class:
        •	"Car/Truck travelled {distance} km"
    Or if it is not:
        •	"Car/Truck needs refueling"
    Finally, print the remaining fuel for both car and truck rounded 2 digits after the floating point in the format:
        •	"Car: {liters}
        •	Truck: {liters}" */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = getVehicles(scanner);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] commandData = scanner.nextLine().split("\\s+");
            String command = commandData[0];
            String vehicleType = commandData[1];
            switch (command) {

                case "Drive":
                    double distance = Double.parseDouble(commandData[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;

                case "Refuel":
                    double liters = Double.parseDouble(commandData[2]);
                    vehicles.get(vehicleType).refuel(liters);
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Map<String, Vehicle> getVehicles(Scanner scanner) {

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        for (int i = 0; i < 2; i++) {
            String[] vehicleData = scanner.nextLine().split("\\s+");
            String vehicleType = vehicleData[0];
            double fuelQuantity = Double.parseDouble(vehicleData[1]);
            double fuelConsumption = Double.parseDouble(vehicleData[2]);
            Vehicle vehicle = null;

            switch (vehicleType) {
                case "Car": vehicle = new Car(fuelQuantity, fuelConsumption);
                    break;
                case "Truck": vehicle = new Truck(fuelQuantity, fuelConsumption);
                    break;
            }
            vehicles.put(vehicleType, vehicle);
        }

        return vehicles;
    }
}
