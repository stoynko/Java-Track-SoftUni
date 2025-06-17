package Y_FinalExam.ExamPrep_V05;

import java.util.*;

public class P03_NeedForSpeedIII {

/*You have just bought the latest and greatest computer game – Need for Seed III. Pick your favorite cars and drive them all you want! We know that you can't wait to start playing.
On the first line of the standard input, you will receive an integer n – the number of cars that you can obtain.
On the next n lines, the cars themselves will follow with their mileage and fuel available, separated by "|" in the following format:
        "{car}|{mileage}|{fuel}"

Then, you will be receiving different commands, each on a new line, separated by " : ", until the "Stop" input is given:

•	"Drive : {car} : {distance} : {fuel}":
        o	You need to drive the given distance, and you will need the given fuel to do that. If the car doesn't have enough fuel, print: "Not enough fuel to make that ride"
        o	If the car has the required fuel available in the tank, increase its mileage with the given distance, decrease its fuel with the given fuel, and print:
        "{car} driven for {distance} kilometers. {fuel} liters of fuel consumed."
        o	You like driving new cars only, so if a car's mileage reaches 100 000 km, remove it from the collection(s) and print: "Time to sell the {car}!"
•	"Refuel : {car} : {fuel}":
        o	Refill the tank of your car.
                o	Each tank can hold a maximum of 75 liters of fuel, so if the given amount of fuel is more than you can fit in the tank, take only what is required to fill it up.
        o	Print a message in the following format: "{car} refueled with {fuel} liters"
•	"Revert : {car} : {kilometers}":
        o	Decrease the mileage of the given car with the given kilometers and print the kilometers you have decreased it with in the following format:
        "{car} mileage decreased by {amount reverted} kilometers"
        o	If the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km and
        DO NOT print anything.
        Upon receiving the "Stop" input, you need to print all cars in your possession in the following format:
        "{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."

Input / Constraints:
    •	The mileage and fuel of the cars will be valid, 32-bit integers, and will never be negative.
    •	The fuel and distance amounts in the commands will never be negative.
    •	The car names in the commands will always be valid cars in your possession.

Output:
•	All the output messages with the appropriate formats are described in the problem description.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carsMileage = new LinkedHashMap<>();
        Map<String, Integer> carsFuel = new LinkedHashMap<>();

        for (int currentCar = 1; currentCar <= numberOfCars; currentCar++) {
            String carData = scanner.nextLine();
            String carName = carData.split("\\|")[0];
            int carMileage = Integer.parseInt(carData.split("\\|")[1]);
            int carFuel = Integer.parseInt(carData.split("\\|")[2]);
            carsMileage.put(carName, carMileage);
            carsFuel.put(carName, carFuel);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {

            String command = input.split(" : ")[0];

            switch (command) {
                case "Drive" -> {
                    String carName = input.split(" : ")[1];
                    int distance = Integer.parseInt(input.split(" : ")[2]);
                    int fuelNeeded = Integer.parseInt(input.split(" : ")[3]);
                    int fuelAvailable = carsFuel.get(carName);

                    if (fuelAvailable >= fuelNeeded) {
                        carsMileage.put(carName, carsMileage.get(carName) + distance);
                        carsFuel.put(carName, carsFuel.get(carName) - fuelNeeded);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", carName, distance, fuelNeeded);
                        if (carsMileage.get(carName) >= 100_000) {
                            carsMileage.remove(carName);
                            carsFuel.remove(carName);
                            System.out.printf("Time to sell the %s!\n", carName);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                }
                case "Refuel" -> {
                    String carName = input.split(" : ")[1];
                    int fuelToAdd = Integer.parseInt(input.split(" : ")[2]);
                    int fuelAdded = 0;
                    int currentCapacity = carsFuel.get(carName);
                    if (currentCapacity + fuelToAdd > 75) {
                        fuelAdded = 75 - currentCapacity;
                    } else {
                        fuelAdded = fuelToAdd;
                    }
                    carsFuel.put(carName, currentCapacity + fuelAdded);
                    System.out.printf("%s refueled with %d liters\n", carName, fuelAdded);
                }
                case "Revert" -> {
                    String carName = input.split(" : ")[1];
                    int mileage = Integer.parseInt(input.split(" : ")[2]);

                    if (carsMileage.get(carName) - mileage >= 10_000) {
                        carsMileage.put(carName, carsMileage.get(carName) - mileage);
                        System.out.printf("%s mileage decreased by %d kilometers\n", carName, mileage);
                    } else {
                        carsMileage.put(carName, 10_000);
                    }
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> car : carsMileage.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", car.getKey(), car.getValue(), carsFuel.get(car.getKey()));
        }
    }
}
