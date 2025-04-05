package B_Java_Fundamentals.F_ObjectsAndClasses.AE02_RawData;

import java.util.*;

public class Main {

/*You are the owner of a courier company and want to make a system for tracking your cars and their cargo.
Define a class Car that holds information about the model, engine, cargo, and a collection of exactly 4 tires.
The engine, cargo, and tire should be separate classes, and create a constructor that receives all
information about the Car and creates and initializes its inner components (engine, cargo, and tires).

On the first line of input, you will receive a number N - the number of cars you have,
on each of the next N lines you will receive information about a car in the format:
"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure} {Tire4Age}",
where the speed, power, weight and tire age are integers, tire pressure is a double.

After the N lines, you will receive a single line with one of 2 commands "fragile" or "flamable",
if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure
is  < 1 if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
The cars should be printed in order to appear in the input. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int carNum = 1; carNum <= numberOfCars; carNum++) {

            String[] inputData = scanner.nextLine().split(" ");
            String model = inputData[0];
            int engineSpeed = Integer.parseInt(inputData[1]);
            int enginePower = Integer.parseInt(inputData[2]);
            int cargoWeight = Integer.parseInt(inputData[3]);
            String cargoType = inputData[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tires> tires = new ArrayList<>();

            for (int element = 5; element <= 12; element += 2) {
                Tires currentTire = new Tires(Double.parseDouble(inputData[element]), Integer.parseInt(inputData[element + 1]));
                tires.add(currentTire);
            }

            Car currentCar = new Car(model, engine, cargo, tires);
            cars.add(currentCar);
        }

        String cargoParameter = scanner.nextLine();
        for (Car car : cars) {
            if (car.searchByParameter(cargoParameter)) {
                System.out.println(car.getModel());
            }
        }
    }
}