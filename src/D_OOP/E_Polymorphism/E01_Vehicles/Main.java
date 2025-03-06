package D_OOP.E_Polymorphism.E01_Vehicles;

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
        String[] carData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandData = scanner.nextLine().split("\\s+");

            switch (commandData[0]) {

                case "Drive":
                    double distance = Double.parseDouble(commandData[2]);
                    if ("Car".equals(commandData[1])) {
                        System.out.println(car.drive(distance));
                    } else if ("Truck".equals(commandData[1])) {
                        System.out.println(truck.drive(distance));
                    }
                    break;

                case "Refuel":
                    double liters = Double.parseDouble(commandData[2]);
                    if ("Car".equals(commandData[1])) {
                        car.refuel(liters);
                    } else if ("Truck".equals(commandData[1])) {
                        truck.refuel(liters);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
