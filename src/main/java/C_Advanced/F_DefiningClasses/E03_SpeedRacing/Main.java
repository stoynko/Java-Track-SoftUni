package C_Advanced.F_DefiningClasses.E03_SpeedRacing;

import java.util.*;

public class Main {

/*Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the cars.
Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer, and distance traveled.
A Car Model is unique - there will never be 2 cars with the same model.

On the first line of the input, you will receive a number N - the number of cars you need to track,
on each of the next N lines you will receive information for a car in the following format "{Model} {FuelAmount} {FuelCostFor1km}",
all cars start at 0 kilometers traveled. After the N lines, until the command "End" is received,
you will receive commands in the following format "Drive {CarModel} {amountOfKm}",
implement a method in the Car class to calculate whether a car can move that distance or not.
If yes, the car fuel amount should be reduced by the amount of used fuel,
and its distance traveled should be increased by the amount of kilometers traveled, otherwise, the car should not move
(Its fuel amount and distance traveled should stay the same) and you should print on the console "Insufficient fuel for the drive".
After the "End" command is received, print each car in order of appearing in input,
and its current fuel amount and distance traveled in the format "{Model} {fuelAmount} {distanceTraveled}",
where the fuel amount should be printed to two decimal places after the separator.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int carsToTrack = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int carNum = 1; carNum <= carsToTrack; carNum++) {

            String[] carData = scanner.nextLine().split(" ");
            String model = carData[0];
            int fuelAmount = Integer.parseInt(carData[1]);
            double fuelCost = Double.parseDouble(carData[2]);

            if (!cars.containsKey(model)) {
                cars.put(model, new Car(model, fuelAmount, fuelCost));
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String command = input.split(" ")[0];
            if (command.equals("Drive")) {
                String model = input.split(" ")[1];
                int amountOfKm = Integer.parseInt(input.split(" ")[2]);
                Car currentCar = cars.get(model);

                if (currentCar.carCanMove(model, amountOfKm)) {
                    currentCar.setFuelAmount(currentCar.getFuelAmount() - (amountOfKm * currentCar.getFuelCostPerKm()));
                    currentCar.setDistanceTraveled(currentCar.getDistanceTraveled() + amountOfKm);
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
            input = scanner.nextLine();
        }
        cars.values().forEach(System.out::print);
    }
}
